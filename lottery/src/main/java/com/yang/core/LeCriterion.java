/**
 * 2018年1月29日
 * Yang.Liu
 */
package com.yang.core;

/**
 * Package : com.yang.core
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月29日 上午11:14:36
 *
 */
public class LeCriterion extends ValueCompareCriterion {
    public LeCriterion(String propName, Comparable<?> value) {
        super(propName, value);
        setOperator(" <= ");
    }
}