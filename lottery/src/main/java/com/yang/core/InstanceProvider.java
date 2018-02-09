package com.yang.core;

import java.lang.annotation.Annotation;

/**
 * Package:com.yixin.ndss.utils.job
 *
 * @author YixinCapital -- Yang.Liu
 *         2018/1/25 14:49
 */
public abstract interface InstanceProvider {
    public abstract <T> T getInstance(Class<T> paramClass);

    public abstract <T> T getInstance(Class<T> paramClass, String paramString);

    public abstract <T> T getInstance(Class<T> paramClass, Class<? extends Annotation> paramClass1);
}
