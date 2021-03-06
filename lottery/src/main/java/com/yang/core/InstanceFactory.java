package com.yang.core;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yang.exception.IocInstanceNotFoundException;
import com.yang.exception.IocInstanceNotUniqueException;
/**
 * Package:com.yixin.ndss.utils.job
 *
 * @author YixinCapital -- Yang.Liu
 *         2018/1/25 14:48
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class InstanceFactory {
    protected final static Logger logger = LoggerFactory.getLogger(InstanceFactory.class);
    private static InstanceProvider instanceProvider;
    private static final Map<Object, Object> instances = new HashMap();

    public static void setInstanceProvider(InstanceProvider provider) {
        instanceProvider = provider;
    }

    public static <T> T getInstance(Class<T> beanType) {
        Object result = null;
        if (null == instanceProvider) {
            setInstanceProvider(new SpringInstanceProvider(SpringContextUtil.getApplicationContext()));
        }
        if (instanceProvider != null) {
            result = getInstanceFromProvider(beanType);
        }
        if (result != null) {
            return (T) result;
        }
        result = getInstanceFromServiceLoader(beanType);
        if (result != null) {
            return (T) result;
        }
        result = instances.get(beanType);
        if (result != null) {
            return (T) result;
        }
        throw new IocInstanceNotFoundException("There's not bean of type '" + beanType + "' exists in IoC container!");
    }

    private static <T> T getInstanceFromProvider(Class<T> beanType) {
        try {
            return instanceProvider.getInstance(beanType);
        } catch (IocInstanceNotFoundException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    private static <T> T getInstanceFromServiceLoader(Class<T> beanType) {
        Set results = new HashSet();
        for (Iterator i$ = ServiceLoader.load(beanType).iterator(); i$.hasNext();) {
            Object instance = i$.next();
            results.add(instance);
        }
        if (results.size() > 1) {
            throw new IocInstanceNotUniqueException("There're more than one bean of type '" + beanType + "'");
        }
        if (results.size() == 1) {
            return (T) results.iterator().next();
        }
        return null;
    }

    public static <T> T getInstance(Class<T> beanType, String beanName) {
        Object result = null;
        if (instanceProvider != null) {
            result = getInstanceFromProvider(beanType, beanName);
        }
        if (result != null) {
            return (T) result;
        }
        result = getInstanceFromServiceLoader(beanType, beanName);
        if (result != null) {
            return (T) result;
        }
        result = instances.get(toName(beanType, beanName));
        if (result != null) {
            return (T) result;
        }
        throw new IocInstanceNotFoundException("There's not bean of type '" + beanType + "' exists in IoC container!");
    }

    private static <T> T getInstanceFromProvider(Class<T> beanType, String beanName) {
        try {
            return instanceProvider.getInstance(beanType, beanName);
        } catch (IocInstanceNotFoundException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    private static <T> T getInstanceFromServiceLoader(Class<T> beanType, String beanName) {
        Set results = new HashSet();
        for (Iterator i$ = ServiceLoader.load(beanType).iterator(); i$.hasNext();) {
            Object instance = i$.next();
            Named named = (Named) instance.getClass().getAnnotation(Named.class);
            if ((named != null) && (beanName.equals(named.value()))) {
                results.add(instance);
            }
        }
        if (results.size() > 1) {
            throw new IocInstanceNotUniqueException("There're more than one bean of type '" + beanType
                    + "' and named '" + beanName + "'");
        }

        if (results.size() == 1) {
            return (T) results.iterator().next();
        }
        return null;
    }

    public static <T> T getInstance(Class<T> beanType, Class<? extends Annotation> annotationType) {
        Object result = null;
        if (instanceProvider != null) {
            result = getInstanceFromProvider(beanType, annotationType);
        }
        if (result != null) {
            return (T) result;
        }
        result = getInstanceFromServiceLoader(beanType, annotationType);
        if (result != null) {
            return (T) result;
        }
        result = instances.get(toName(beanType, annotationType));
        if (result != null) {
            return (T) result;
        }
        throw new IocInstanceNotFoundException("There's not bean '" + annotationType + "' of type '" + beanType
                + "' exists in IoC container!");
    }

    private static <T> T getInstanceFromProvider(Class<T> beanType, Class<? extends Annotation> annotationType) {
        try {
            return instanceProvider.getInstance(beanType, annotationType);
        } catch (IocInstanceNotFoundException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    private static <T> T getInstanceFromServiceLoader(Class<T> beanType, Class<? extends Annotation> annotationType) {
        Set results = new HashSet();
        for (Iterator i$ = ServiceLoader.load(beanType).iterator(); i$.hasNext();) {
            Object instance = i$.next();
            Annotation beanAnnotation = instance.getClass().getAnnotation(annotationType);
            if ((beanAnnotation != null) && (beanAnnotation.annotationType().equals(annotationType))) {
                results.add(instance);
            }
        }
        if (results.size() > 1) {
            throw new IocInstanceNotUniqueException("There're more than one bean of type '" + beanType
                    + "' and annotated with '" + annotationType + "'");
        }

        if (results.size() == 1) {
            return (T) results.iterator().next();
        }
        return null;
    }

    public static <T> void bind(Class<T> serviceInterface, T serviceImplementation) {
        instances.put(serviceInterface, serviceImplementation);
    }

    public static <T> void bind(Class<T> serviceInterface, T serviceImplementation, String beanName) {
        instances.put(toName(serviceInterface, beanName), serviceImplementation);
    }

    public static void clear() {
        instances.clear();
    }

    public static <T> void bind(Class<T> serviceInterface, T serviceImplementation,
                                Class<? extends Annotation> annotationType) {
        instances.put(toName(serviceInterface, annotationType), serviceImplementation);
    }

    private static String toName(Class<?> beanType, String beanName) {
        return beanType.getName() + ":" + beanName;
    }

    private static String toName(Class<?> beanType, Class<? extends Annotation> annotationType) {
        return beanType.getName() + ":" + annotationType.getName();
    }
}
