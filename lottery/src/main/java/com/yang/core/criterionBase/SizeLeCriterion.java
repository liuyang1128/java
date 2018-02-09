/**
 * 2018年1月29日
 * Yang.Liu
 */
package com.yang.core.criterionBase;

/**
 * Package : com.yang.core.criterionBase
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月29日 上午11:30:39
 *
 */
public class SizeLeCriterion extends SizeCompareCriterion {
    public SizeLeCriterion(String propName, int value) {
        super(propName, value);
        setOperator(" <= ");
    }
}