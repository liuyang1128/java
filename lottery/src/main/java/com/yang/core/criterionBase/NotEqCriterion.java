/**
 * 2018年1月29日
 * Yang.Liu
 */
package com.yang.core.criterionBase;

import com.yang.core.ValueCompareCriterion;

/**
 * Package : com.yang.core
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月29日 上午11:13:03
 *
 */
public class NotEqCriterion extends ValueCompareCriterion {
    public NotEqCriterion(String propName, Object value) {
        super(propName, 	value);
        setOperator(" != ");
    }
}