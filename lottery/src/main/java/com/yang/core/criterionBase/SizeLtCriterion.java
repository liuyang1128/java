/**
 * 2018年1月29日
 * Yang.Liu
 */
package com.yang.core.criterionBase;

/**
 * Package : com.yang.core.criterionBase
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月29日 上午11:30:06
 *
 */
public class SizeLtCriterion extends SizeCompareCriterion {
    public SizeLtCriterion(String propName, int value) {
        super(propName, value);
        setOperator(" < ");
    }
}