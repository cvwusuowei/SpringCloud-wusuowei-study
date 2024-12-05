package com.wusuowei.cloud.function;

@FunctionalInterface
public interface BeanCopyCallBack<S, T> {
    void callBack(S t, T s);
}
