package com_4.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 消费者
 */
public class Client {
    public static void main(String[] args) {


        Producer producer = new Producer();
        /**
         * 动态代理：
         *      特点：字节码随意创建，随用随加载
         *      作用：不用修改源码的基础上对方法增强
         *      分类：
         *          基于接口的动态代理 ：
         *                  涉及的类 Proxy  提供者：JDK官方
         *                  如何创建代理对象：
         *                              使用Proxy类中的newProxyInstance方法
         *                  创建代理对象的要求：
         *                              被代理类至少实现一个接口，如果没有则不能使用
         *              newProxyInstance方法的参数：
         *                  ClassLoarder:类加载器
         *                      它是用于加载代理对象的字节码的。和被代理对象使用相同的类加载器，固定写法。
         *                  Class[]:字节码数组
         *                      它是用于让代理对象和被代理对象具有相同方法。固定写法。
         *                  InvocationHandler:用于增强的代码
         *                      它是让我们写如何代理。一般都是一个该接口的实现类，通常情况下都是匿名类，但不是必须的
         *
         *
         */

        IProducer ProxyProducer = (IProducer)Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 作用：执行被代理对象的任何接口方法都会经过该方法
                     * @param proxy  代理对象的引用
                     * @param method  当前执行的方法
                     * @param args 当前执行方法所需的参数
                     * @return  和被代理对象有相同的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //提供增强的代码
                        Object value = null;
                        // 1.获取方法执行的参数
                        float money = (float)args[0];
                        // 2.判断是否进行增强
                        if("saleProduct".equals(method.getName())){
                            System.out.println("================jdk动态代理================");
                            value = method.invoke(producer,money*0.8f);
                        }
                        return value;
                    }
                });
        ProxyProducer.saleProduct(1000f);
    }

}
