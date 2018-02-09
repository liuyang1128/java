/**
 * 2018年1月29日
 * Yang.Liu
 */
package com.yang.core.criterionBase;

import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.yang.core.BeanUtils;
import com.yang.core.NamedParameters;

/**
 * Package : com.yang.core.criterionBase
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月29日 上午11:24:33
 *
 */
public abstract class SizeCompareCriterion extends BasicCriterion {
    protected final int value;
    private String operator;

    public SizeCompareCriterion(String propName, int value) {
        super(propName);
        this.value = value;
    }

    public Object getValue() {
        return Integer.valueOf(this.value);
    }

    protected final void setOperator(String operator) {
        this.operator = operator;
    }

    public String toQueryString() {
        return "size(" + getPropNameWithAlias() + ")" + this.operator + getParamNameWithColon();
    }

    public NamedParameters getParameters() {
        return NamedParameters.create().add(getParamName(), Integer.valueOf(this.value));
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!getClass().isAssignableFrom(other.getClass())) {
            return false;
        }
        Map thisPropValues = new BeanUtils(this).getPropValues();
        Map otherPropValues = new BeanUtils(other).getPropValues();
        return new EqualsBuilder().append(thisPropValues.get("propName"), otherPropValues.get("propName"))
                .append(thisPropValues.get("value"), otherPropValues.get("value")).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getPropName()).append(getValue()).toHashCode();
    }

    public String toString() {
        return "size of " + getPropName() + this.operator + this.value;
    }
}