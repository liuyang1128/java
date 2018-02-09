/**
 * 2018年1月27日
 * Yang.Liu
 */
package com.yang.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yang.exception.IocInstanceNotFoundException;

/**
 * Package : com.yang.core
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月27日 下午10:13:30
 *
 */
public class EntityManagerProvider {
    protected final static Logger logger = LoggerFactory.getLogger(EntityManagerProvider.class);
    private EntityManagerFactory entityManagerFactory;
    private final ThreadLocal<EntityManager> entityManagerHolder = new ThreadLocal<EntityManager>();

    public EntityManagerProvider() {
        this.entityManagerFactory = (InstanceFactory.getInstance(EntityManagerFactory.class));
    }

    public EntityManagerProvider(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public EntityManagerProvider(EntityManager entityManager) {
        this.entityManagerHolder.set(entityManager);
    }

    public EntityManager getEntityManager() {
        EntityManager result = this.entityManagerHolder.get();
        if ((result != null) && (result.isOpen())) {
            return result;
        }
        result = getEntityManagerFromIoC();
        this.entityManagerHolder.set(result);
        return result;
    }

    public EntityManager getEntityManagerFromIoC() {
        try {
            return InstanceFactory.getInstance(EntityManager.class);
        } catch (IocInstanceNotFoundException e) {
            logger.error(e.getMessage(), e);
            if (this.entityManagerFactory == null)
                this.entityManagerFactory = InstanceFactory.getInstance(EntityManagerFactory.class);
        }
        return this.entityManagerFactory.createEntityManager();
    }
}