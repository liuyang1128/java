/**
 * 2018年1月29日
 * Yang.Liu
 */
package com.yang.core.criterionBase;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.yang.core.NamedParameters;

/**
 * Package : com.yang
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月29日 上午10:36:13
 *
 */
public class NotCriterion extends AbstractCriterion {
    private final QueryCriterion criterion;

    public NotCriterion(QueryCriterion criterion) {
        this.criterion = criterion;
    }

    public QueryCriterion getCriteron() {
        return this.criterion;
    }

    public String toQueryString() {
        return "not (" + this.criterion.toQueryString() + ")";
    }

    public NamedParameters getParameters() {
        return this.criterion.getParameters();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotCriterion)) {
            return false;
        }
        NotCriterion that = (NotCriterion) other;
        return new EqualsBuilder().append(getCriteron(), that.getCriteron()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getCriteron()).toHashCode();
    }
}