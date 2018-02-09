/**
 * 2018年1月29日
 * Yang.Liu
 */
package com.yang.core.criterionBase;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang3.StringUtils;

import com.yang.core.NamedParameters;

/**
 * Package : com.yang.core
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月29日 上午10:34:54
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class AndCriterion extends AbstractCriterion {
    private final List<QueryCriterion> criterions;

    public AndCriterion(QueryCriterion[] criterions) {
        this.criterions = removeNullOrEmptyCriterion(criterions);
    }

    public List<QueryCriterion> getCriterons() {
        return this.criterions;
    }

    public String toQueryString() {
        List subCriterionsStr = new ArrayList();
        for (QueryCriterion each : getCriterons()) {
            subCriterionsStr.add(each.toQueryString());
        }
        return StringUtils.join(subCriterionsStr, " and ");
    }

    public NamedParameters getParameters() {
        NamedParameters result = NamedParameters.create();
        for (QueryCriterion each : getCriterons()) {
            result.add(each.getParameters());
        }
        return result;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AndCriterion)) {
            return false;
        }
        AndCriterion that = (AndCriterion) other;
        return new EqualsBuilder().append(getCriterons(), that.getCriterons()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getCriterons()).toHashCode();
    }
}