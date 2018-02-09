/**
 * 2018年1月29日
 * Yang.Liu
 */
package com.yang.core.criterionBase;

import com.yang.core.criterionBase.PropertyCompareCriterion;

/**
 * Package : com.yang.core
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月29日 上午11:19:03
 *
 */
public class NotEqPropCriterion extends PropertyCompareCriterion {
    public NotEqPropCriterion(String propName, String otherPropName) {
        super(propName, otherPropName);
        setOperator(" != ");
    }
}