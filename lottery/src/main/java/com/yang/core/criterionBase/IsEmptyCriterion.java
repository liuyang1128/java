/**
 * 2018年1月29日
 * Yang.Liu
 */
package com.yang.core.criterionBase;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.yang.core.NamedParameters;

/**
 * Package : com.yang.core.criterionBase
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月29日 上午11:37:20
 *
 */
public class IsEmptyCriterion extends BasicCriterion {
    public IsEmptyCriterion(String propName) {
        super(propName);
    }

    public String toQueryString() {
        return getPropNameWithAlias() + " is empty";
    }

    public NamedParameters getParameters() {
        return NamedParameters.create();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IsEmptyCriterion)) {
            return false;
        }
        IsEmptyCriterion that = (IsEmptyCriterion) other;
        return new EqualsBuilder().append(getPropName(), that.getPropName()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getPropName()).toHashCode();
    }

    public String toString() {
        return getPropName() + " is empty";
    }
}