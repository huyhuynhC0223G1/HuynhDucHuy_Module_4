package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MainAspect {
    private long numberOfRequestsToServer = 0;

    @Pointcut("within(com.example.demo.controller.*)")
    public void countNumberOfRequestsToServer() {
    }

    @Before("countNumberOfRequestsToServer()")
    public void beforeCountNumberOfClientsHandler(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName());
        this.numberOfRequestsToServer++;
        System.out.println("The number before of request to server: " + this.numberOfRequestsToServer);
    }

//    @AfterReturning(value = "logshowFormBorrow()", returning = "returned")
//    public void logshowFormBorrowHandler(JoinPoint joinPoint, Object returned){
//        System.out.println(joinPoint.getSignature().getName());
//        System.out.println(joinPoint.getArgs()[0].toString());
//        System.out.println(returned);
//    }

    @After("countNumberOfRequestsToServer()")
    public void afterCountNumberOfClientsHandler(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName());
        this.numberOfRequestsToServer++;
        System.out.println("The number after of request to server: " + this.numberOfRequestsToServer);
    }
}
