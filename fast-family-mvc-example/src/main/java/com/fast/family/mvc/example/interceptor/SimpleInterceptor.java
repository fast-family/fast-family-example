package com.fast.family.mvc.example.interceptor;

import com.fast.family.log.AccessLogInfo;
import com.fast.family.log.AccessLogInterceptor;
import com.fast.family.log.aop.AccessLogMethodInterceptor;

/**
 * @author 张顺
 * @version 1.0
 */
public class SimpleInterceptor implements AccessLogInterceptor {

    @Override
    public void before(AccessLogInfo accessLogInfo) {
        System.out.println("before");
    }

    @Override
    public void after(AccessLogInfo accessLogInfo) {
        System.out.println("after");
    }
}
