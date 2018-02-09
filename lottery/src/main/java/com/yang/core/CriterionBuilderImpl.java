/**
 * 2018年1月29日
 * Yang.Liu
 */
package com.yang.core;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.yang.core.criterionBase.AndCriterion;
import com.yang.core.criterionBase.BetweenCriterion;
import com.yang.core.criterionBase.ContainsTextCriterion;
import com.yang.core.criterionBase.InCriterion;
import com.yang.core.criterionBase.IsEmptyCriterion;
import com.yang.core.criterionBase.IsNullCriterion;
import com.yang.core.criterionBase.LePropCriterion;
import com.yang.core.criterionBase.LtPropCriterion;
import com.yang.core.criterionBase.NotCriterion;
import com.yang.core.criterionBase.NotEmptyCriterion;
import com.yang.core.criterionBase.NotEqCriterion;
import com.yang.core.criterionBase.NotEqPropCriterion;
import com.yang.core.criterionBase.NotInCriterion;
import com.yang.core.criterionBase.NotNullCriterion;
import com.yang.core.criterionBase.OrCriterion;
import com.yang.core.criterionBase.QueryCriterion;
import com.yang.core.criterionBase.SizeEqCriterion;
import com.yang.core.criterionBase.SizeGeCriterion;
import com.yang.core.criterionBase.SizeGtCriterion;
import com.yang.core.criterionBase.SizeLeCriterion;
import com.yang.core.criterionBase.SizeLtCriterion;
import com.yang.core.criterionBase.SizeNotEqCriterion;
import com.yang.core.criterionBase.StartsWithTextCriterion;

/**
 * Package : com.yang.core
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月29日 上午10:32:16
 *
 */
@Component
public class CriterionBuilderImpl implements CriterionBuilder {
    public QueryCriterion eq(String propName, Object value) {
        return new EqCriterion(propName, value);
    }

    public QueryCriterion notEq(String propName, Object value) {
        return new NotEqCriterion(propName, value);
    }

    public QueryCriterion ge(String propName, Comparable<?> value) {
        return new GeCriterion(propName, value);
    }

    public QueryCriterion gt(String propName, Comparable<?> value) {
        return new GtCriterion(propName, value);
    }

    public QueryCriterion le(String propName, Comparable<?> value) {
        return new LeCriterion(propName, value);
    }

    public QueryCriterion lt(String propName, Comparable<?> value) {
        return new LtCriterion(propName, value);
    }

    public QueryCriterion eqProp(String propName, String otherPropName) {
        return new EqPropCriterion(propName, otherPropName);
    }

    public QueryCriterion notEqProp(String propName, String otherPropName) {
        return new NotEqPropCriterion(propName, otherPropName);
    }

    public QueryCriterion gtProp(String propName, String otherPropName) {
        return new GtPropCriterion(propName, otherPropName);
    }

    public QueryCriterion geProp(String propName, String otherPropName) {
        return new GePropCriterion(propName, otherPropName);
    }

    public QueryCriterion ltProp(String propName, String otherPropName) {
        return new LtPropCriterion(propName, otherPropName);
    }

    public QueryCriterion leProp(String propName, String otherPropName) {
        return new LePropCriterion(propName, otherPropName);
    }

    public QueryCriterion sizeEq(String propName, int size) {
        return new SizeEqCriterion(propName, size);
    }

    public QueryCriterion sizeNotEq(String propName, int size) {
        return new SizeNotEqCriterion(propName, size);
    }

    public QueryCriterion sizeGt(String propName, int size) {
        return new SizeGtCriterion(propName, size);
    }

    public QueryCriterion sizeGe(String propName, int size) {
        return new SizeGeCriterion(propName, size);
    }

    public QueryCriterion sizeLt(String propName, int size) {
        return new SizeLtCriterion(propName, size);
    }

    public QueryCriterion sizeLe(String propName, int size) {
        return new SizeLeCriterion(propName, size);
    }

    public QueryCriterion containsText(String propName, String value) {
        return new ContainsTextCriterion(propName, value);
    }

    public QueryCriterion startsWithText(String propName, String value) {
        return new StartsWithTextCriterion(propName, value);
    }

    public QueryCriterion in(String propName, Collection<?> value) {
        return new InCriterion(propName, value);
    }

    public QueryCriterion in(String propName, Object[] value) {
        return new InCriterion(propName, value);
    }

    public QueryCriterion notIn(String propName, Collection<?> value) {
        return new NotInCriterion(propName, value);
    }

    public QueryCriterion notIn(String propName, Object[] value) {
        return new NotInCriterion(propName, value);
    }

    public QueryCriterion between(String propName, Comparable<?> from, Comparable<?> to) {
        return new BetweenCriterion(propName, from, to);
    }

    public QueryCriterion isNull(String propName) {
        return new IsNullCriterion(propName);
    }

    public QueryCriterion notNull(String propName) {
        return new NotNullCriterion(propName);
    }

    public QueryCriterion isEmpty(String propName) {
        return new IsEmptyCriterion(propName);
    }

    public QueryCriterion notEmpty(String propName) {
        return new NotEmptyCriterion(propName);
    }

    public QueryCriterion isTrue(String propName) {
        return eq(propName, Boolean.valueOf(true));
    }

    public QueryCriterion isFalse(String propName) {
        return eq(propName, Boolean.valueOf(false));
    }

    public QueryCriterion isBlank(String propName) {
        return or(new QueryCriterion[] { isNull(propName), eq(propName, "") });
    }

    public QueryCriterion notBlank(String propName) {
        return and(new QueryCriterion[] { notNull(propName), notEq(propName, "") });
    }

    public QueryCriterion not(QueryCriterion criterion) {
        return new NotCriterion(criterion);
    }

    public QueryCriterion and(QueryCriterion[] criterions) {
        return new AndCriterion(criterions);
    }

    public QueryCriterion or(QueryCriterion[] criterions) {
        return new OrCriterion(criterions);
    }

    public QueryCriterion empty() {
        return new EmptyCriterion();
    }
}

