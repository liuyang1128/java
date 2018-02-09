/**
 * 2018年1月29日
 * Yang.Liu
 */
package com.yang.core;

import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.yang.core.criterionBase.BasicCriterion;

/**
 * Package : com.yang.core
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月29日 上午10:39:08
 *
 */
public abstract class ValueCompareCriterion extends BasicCriterion {
    protected final Object value;
    private String operator;

    public ValueCompareCriterion(String propName, Object value) {
        super(propName);
        this.value = value;
    }

    public Object getValue() {
        return this.value;
    }

    protected final void setOperator(String operator) {
        this.operator = operator;
    }

    public String toQueryString() {
        return getPropNameWithAlias() + this.operator + getParamNameWithColon();
    }

    public NamedParameters getParameters() {
        return NamedParameters.create().add(getParamName(), this.value);
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
        return getPropName() + this.operator + this.value;
    }
}