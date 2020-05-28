package com_4.factory;

import com_4.domain.Account;
import com_4.service.IAccountService;
import com_4.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * 用于创建Service的代理对象的工厂
 */
public class BeanFactory {

    private IAccountService accountService;
    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public  void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }
    /**
     * 获取Service代理对象
     */
    public IAccountService getAccountService(){
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                /**
                 * 添加事务的支持
                 */
                //// AOP 四种通知类型
                new InvocationHandler() {
                    @Override   // 整个invoke方法的执行就是环绕通知
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;
                        try {
                            // 1.开启事务   // 前置通知
                            txManager.beginTransaction();
                            //2.执行操作
                            rtValue = method.invoke(accountService,args);  // 在环绕通知中有明确的切入点方法调用
                            //3.提交事务
                            txManager.commit();  // 后置通知
                            //4.返回结果
                            return rtValue;

                        }catch (Exception e){
                            // 5.回滚操作
                            txManager.rollback(); // 异常通知
                            throw new RuntimeException(e);

                        }finally {
                            // 6.释放连接
                            txManager.release();  // 最终通知
                        }


                    }
                });
    }
}
