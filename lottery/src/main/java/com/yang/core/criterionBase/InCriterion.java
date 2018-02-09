/**
 * 2018年1月29日
 * Yang.Liu
 */
package com.yang.core.criterionBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang3.StringUtils;

import com.yang.core.Entity;
import com.yang.core.NamedParameters;

/**
 * Package : com.yang.core.criterionBase
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月29日 上午11:32:22
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class InCriterion extends BasicCriterion {
    private Collection<? extends Object> value = new ArrayList();

    public InCriterion(String propName, Collection<? extends Object> value) {
        super(propName);
        if (value != null)
            this.value = value;
    }

    public InCriterion(String propName, Object[] value) {
        super(propName);
        if ((value != null) && (value.length > 0))
            this.value = Arrays.asList(value);
    }

    public Collection<? extends Object> getValue() {
        return this.value;
    }

    public String toQueryString() {
        if ((this.value == null) || (this.value.isEmpty())) {
            return "1 > 1";
        }
        return getPropNameWithAlias() + " in " + getParamNameWithColon();
    }

    public NamedParameters getParameters() {
        NamedParameters result = NamedParameters.create();
        if (!this.value.isEmpty()) {
            result = result.add(getParamName(), this.value);
        }
        return result;
    }

    private String createInString(Collection<? extends Object> value) {
        Set elements = new HashSet();
        for (Iterator i$ = value.iterator(); i$.hasNext();) {
            Object item = i$.next();
            Object element;
            if ((item instanceof Entity))
                element = ((Entity) item).getId();
            else {
                element = item;
            }
            if (((element instanceof String)) || ((element instanceof Date))) {
                element = "'" + element + "'";
            }
            elements.add(element);
        }
        return StringUtils.join(elements, ", ");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InCriterion)) {
            return false;
        }
        InCriterion that = (InCriterion) other;
        return new EqualsBuilder().append(getPropName(), that.getPropName()).append(this.value, that.value).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getPropName()).append(this.value).toHashCode();
    }

    public String toString() {
        return getPropName() + " in collection [" + collectionToString(this.value) + "]";
    }

    private String collectionToString(Collection<? extends Object> value) {
        return StringUtils.join(value, ", ");
    }
}