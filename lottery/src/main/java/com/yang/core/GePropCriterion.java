/**
 * 2018年1月29日
 * Yang.Liu
 */
package com.yang.core;

import com.yang.core.criterionBase.PropertyCompareCriterion;

/**
 * Package : com.yang.core
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月29日 上午11:20:31
 *
 */
public class GePropCriterion extends PropertyCompareCriterion {
    public GePropCriterion(String propName, String otherPropName) {
        super(propName, otherPropName);
        setOperator(" >= ");
    }
}