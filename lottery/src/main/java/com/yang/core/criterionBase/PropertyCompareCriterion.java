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
 * Package : com.yang.core
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月29日 上午11:18:27
 *
 */
public abstract class PropertyCompareCriterion extends BasicCriterion {
    private final String otherPropName;
    private String operator;

    public PropertyCompareCriterion(String propName, String otherPropName) {
        super(propName);
        this.otherPropName = otherPropName;
    }

    public String getOtherPropName() {
        return this.otherPropName;
    }

    protected final void setOperator(String operator) {
        this.operator = operator;
    }

    public String toQueryString() {
        return getPropNameWithAlias() + this.operator + "rootEntity" + "." + this.otherPropName;
    }

    public NamedParameters getParameters() {
        return NamedParameters.create();
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
                .append(thisPropValues.get("otherPropName"), otherPropValues.get("otherPropName")).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getPropName()).append(getOtherPropName()).toHashCode();
    }

    public String toString() {
        return getPropName() + this.operator + getOtherPropName();
    }
}