package com_4.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;
import com_4.cglib.Producer;

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
         *            基于子类的动态代理 ：
         *                  涉及的类 Enhancer  提供者：第三方cglib库
         *                  如何创建代理对象：
         *                              使用Enhancer类中的create方法
         *                  创建代理对象的要求：
         *                              被代理类不能是最终类
         *                  create方法的参数：
         *                  Class:字节码
         *                      它是用于指定被代理对象的字节码。
         *
         *                  Callback:用于增强的代码
         *                      它是让我们写如何代理。一般都是一个该接口的实现类，通常情况下都是匿名类，但不是必须的
         *                      一般写的是该接口的子接口实现类，MethodInterceptor
         *
         *
         */
        Producer cglibProducer = (Producer)Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * 执行被代理对象的任何方法都会经过该方法
             * @param proxy
             * @param method
             * @param methodProxy
             *
             * 以上三个参数和基于接口的动态代理invoke方法的参数是一样的
             * @param methodProxy 当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                //提供增强的代码
                Object value = null;
                // 1.获取方法执行的参数
                float money = (float)args[0];
                // 2.判断是否进行增强
                if("saleProduct".equals(method.getName())){
                    System.out.println("==================cglib动态代理===============");
                    value = method.invoke(producer,money*0.8f);
                }
                return value;
            }
        });

        cglibProducer.saleProduct(1000f);

    }

}
