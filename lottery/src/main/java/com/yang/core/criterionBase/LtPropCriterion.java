/**
 * 2018年1月29日
 * Yang.Liu
 */
package com.yang.core.criterionBase;

/**
 * Package : com.yang.core.criterionBase
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月29日 上午11:21:48
 *
 */
public class LtPropCriterion extends PropertyCompareCriterion {
    public LtPropCriterion(String propName, String otherPropName) {
        super(propName, otherPropName);
        setOperator(" < ");
    }
}