package com.factory;

import com.impl.AccountServiceImpl;
import com.service.IAccountService;

public class StaticFactory {
    public static IAccountService getAccountService(){
        //return new AccountServiceImpl();
        return null;
    }
}
