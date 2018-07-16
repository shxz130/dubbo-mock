package com.github.dumock.core.aspect;

import com.google.common.base.Joiner;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * Created by jetty on 18/7/16.
 */
@Aspect   //定义一个切面
@Configuration
@Order(-98)
public class CoreLoggerAspect {

    private static final Logger logger = LoggerFactory.getLogger(CoreLoggerAspect.class);

    // 定义切点Pointcut
    @Pointcut("execution(* com.github.dumock.core.handler..*(..))")
    private void logger() {
    }

    @Around("logger()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        String  parameter=getParameter(pjp);
        String className=pjp.getSignature().getDeclaringTypeName();
        String methodName=pjp.getSignature().getName();
        long startTime=System.currentTimeMillis();
        logger.info(String.format("[%s.%s]请求开始,请求参数[%s]", className,methodName,parameter));
        Object result = pjp.proceed();
        logger.info(String.format("[%s.%s]请求结束，返回数据%s 响应时长%sms" ,className,methodName, result,System.currentTimeMillis()-startTime));
        return result;
    }

    private String getParameter(ProceedingJoinPoint pjp){
        Object[] args=pjp.getArgs();
        return Joiner.on(',').skipNulls().join(args);
    }

}
