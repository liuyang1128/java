/**
 * 2018年1月29日
 * Yang.Liu
 */
package com.yang.core.criterionBase;

/**
 * Package : com.yang.core.criterionBase
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月29日 上午11:25:59
 *
 */
public class SizeGtCriterion extends SizeCompareCriterion {
    public SizeGtCriterion(String propName, int value) {
        super(propName, value);
        setOperator(" > ");
    }
}