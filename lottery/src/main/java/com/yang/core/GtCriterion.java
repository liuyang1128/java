/**
 * 2018年1月29日
 * Yang.Liu
 */
package com.yang.core;

/**
 * Package : com.yang.core
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月29日 上午11:14:16
 *
 */
public class GtCriterion extends ValueCompareCriterion {
    public GtCriterion(String propName, Comparable<?> value) {
        super(propName, value);
        setOperator(" > ");
    }
}