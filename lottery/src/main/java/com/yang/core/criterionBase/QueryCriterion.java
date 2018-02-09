package com.yang.core.criterionBase;

import com.yang.core.NamedParameters;

/**
 * Package:com.yixin.ndss.assembler.common
 *
 * @author YixinCapital -- Yang.Liu
 *         2018/1/26 10:20
 */
public abstract interface QueryCriterion {
    public static final String ROOT_ALIAS = "rootEntity";

    public abstract QueryCriterion and(QueryCriterion paramQueryCriterion);

    public abstract QueryCriterion or(QueryCriterion paramQueryCriterion);

    public abstract QueryCriterion not();

    public abstract boolean isEmpty();

    public abstract String toQueryString();

    public abstract NamedParameters getParameters();
}
