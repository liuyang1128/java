/**
 * 2018年1月27日
 * Yang.Liu
 */
package com.yang.core;

import java.util.List;

/**
 * Package : com.yang.core
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月27日 下午10:03:00
 *
 */
public class NamedQuery extends BaseQuery<NamedQuery> {
    private final String queryName;

    public NamedQuery(EntityRepository repository, String queryName) {
        super(repository);
        this.queryName = queryName;
    }

    public String getQueryName() {
        return this.queryName;
    }

    public <T> List<T> list() {
        return getRepository().find(this);
    }

    public <T> T singleResult() {
        return getRepository().getSingleResult(this);
    }

    public int executeUpdate() {
        return getRepository().executeUpdate(this);
    }
}

