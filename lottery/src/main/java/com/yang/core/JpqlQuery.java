package com.yang.core;

import java.util.List;

/**
 * Package:com.yixin.ndss.assembler.common.entity
 *
 * @author YixinCapital -- Yang.Liu
 *         2018/1/26 9:53
 */
public class JpqlQuery extends BaseQuery<JpqlQuery> {
    private final String jpql;

    public JpqlQuery(EntityRepository repository, String jpql) {
        super(repository);
        this.jpql = jpql;
    }

    public String getJpql() {
        return this.jpql;
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
