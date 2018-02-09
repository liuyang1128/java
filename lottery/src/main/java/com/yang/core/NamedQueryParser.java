/**
 * 2018年1月27日
 * Yang.Liu
 */
package com.yang.core;

import javax.persistence.EntityManager;

/**
 * Package : com.yang.core
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月27日 下午10:12:53
 *
 */
public abstract class NamedQueryParser {
    private EntityManagerProvider entityManagerProvider;

    public NamedQueryParser() {
    }

    public NamedQueryParser(EntityManagerProvider entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

    public void setEntityManagerProvider(EntityManagerProvider entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

    protected EntityManager getEntityManager() {
        return this.entityManagerProvider.getEntityManager();
    }

    public abstract String getQueryStringOfNamedQuery(String paramString);
}

