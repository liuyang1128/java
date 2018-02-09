/**
 * 2018年1月29日
 * Yang.Liu
 */
package com.yang.core;

import org.apache.commons.lang.builder.HashCodeBuilder;

import com.yang.core.criterionBase.AbstractCriterion;
import com.yang.core.criterionBase.QueryCriterion;

/**
 * Package : com.yang.core
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月29日 上午10:37:31
 *
 */
public class EmptyCriterion extends AbstractCriterion {
    public QueryCriterion and(QueryCriterion criterion) {
        return criterion;
    }

    public QueryCriterion or(QueryCriterion criterion) {
        return criterion;
    }

    public QueryCriterion not() {
        return this;
    }

    public boolean isEmpty() {
        return true;
    }

    public String toQueryString() {
        return "";
    }

    public NamedParameters getParameters() {
        return NamedParameters.create();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        return (other instanceof EmptyCriterion);
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 31).toHashCode();
    }
}