package com.ly.springcloud.config;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author luoyong
 *  * @create 2020-04-12 10:44 上午
 *  * @last modify by [luoyong 2020-04-12 10:44 上午]
 * @Description: 请求日志打印
 **/
@Slf4j
@Aspect
@Component
public class LogHandingAspect {

    @Value("${server.port}")
    private String serverPort;

    /**
     * @return void
     * @Description: 声明切点
     * @author luoyong
     * @create 10:46 上午 2020/4/12
     * @last modify by [LuoYong 10:46 上午 2020/4/12 ]
     */
    @Pointcut("execution(* com.ly.springcloud.controller..*.*(..))")
    public void logHandler() {
        // Do nothing because of X and Y.
    }


    /**
     * @param joinPoint 切点
     * @return
     * @Description: 切点打印入参、出参、执行时间
     * @author luoyong
     * @create 10:50 上午 2020/4/12
     * @last modify by [LuoYong 10:50 上午 2020/4/12 ]
     */
    @Around("logHandler()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取当前请求绑定的所有属性
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取调用方法
        Method method = signature.getMethod();
        //根据调用方法得到调用类
        Class<?> targetClass = method.getDeclaringClass();
        //组装类名和方法名
        String classAndMethodName = targetClass.getName() + "#" + method.getName();

        //服务端口
        log.warn("服务端口是: {}", serverPort);
        // 请求url
        log.warn("请求url：{}", request.getRequestURL());
        // 请求方法
        log.warn("请求方法：{}", request.getMethod());
        //获取方法请求参数
        log.warn("调用开始-- {} 参数:{}", classAndMethodName, joinPoint.getArgs());

        //获取方法返回结果并计算调用时间
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long timeConsuming = System.currentTimeMillis() - start;
        if (null == result) {
            log.warn("调用结束--返回结果为空");
            log.warn("调用结束-- {} 返回值:{} 耗时:{}ms", classAndMethodName, null, timeConsuming);
        } else {
            log.warn("调用结束-- {} 返回值:{} 耗时:{}ms", classAndMethodName, JSONObject.toJSON(result).toString(), timeConsuming);
        }
        return result;
    }

}
