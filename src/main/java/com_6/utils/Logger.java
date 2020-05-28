package com_6.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 用于记录日志的工具类，它里面提供了公共的代码
 */
public class Logger {
    /**
     * 前置通知
     */
    public  void  beforePrintLog(){
        System.out.println("Logger类中的beforePrintLog方法开始记录日志了..");
    }
    /**
     * 后置通知
     */
    public  void  afterReturningPrintLog(){
        System.out.println("Logger类中的AfterReturningPrintLog方法开始记录日志了..");
    }
    /**
     * 异常通知
     */
    public  void  afterThrowingPrintLog(){
        System.out.println("Logger类中的AfterThrowingPrintLog方法开始记录日志了..");
    }
    /**
     * 最终通知
     */
    public  void  afterPrintLog(){
        System.out.println("Logger类中的afterPrintLog方法开始记录日志了..");
    }

    /**
     * 环绕通知
     * 问题：
     *      当配置了环绕通知，切入点方法没有执行，但通知方法执行了
     * 分析：
     *      通过对比动态代理中的环绕通知代码，发现动态代理中的环绕通知有明确的切入点方法调用，而这里的代码没有
     *  解决：
     *      spring提供了一个接口：ProceedingJoinPoint。该接口有一个方法proceed()，此方法相当于明确调用切入点方法，
     *      该接口可以作为 环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用。
     *
     *   spring中的环绕通知：
     *      它是spring为我们提供的一种可以在代码中手动控制增强方法何时执行的方式。（除了配置的方式实现各种通知，还可以以代码的方法实现）
     */
    public Object printLog(ProceedingJoinPoint pjp){
        Object value = null;
        System.out.println("Logger类中的PrintLog方法执行了  前置");
        try {
            Object[] args = pjp.getArgs();// 得到方法所需的参数
            value = pjp.proceed(args); //明确调用业务层方法（切入点方法）
            System.out.println("Logger类中的PrintLog方法执行了  后置");
            return value;
        }catch (Throwable t){
            System.out.println("Logger类中的PrintLog方法执行了  异常");
            throw  new RuntimeException(t);

        }finally {
            System.out.println("Logger类中的PrintLog方法执行了  最终");

        }

    }

}
