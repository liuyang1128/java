/**
 * 2018年1月29日
 * Yang.Liu
 */
package com.yang.core;

/**
 * Package : com.yang.core
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月29日 上午11:15:12
 *
 */
public class LtCriterion extends ValueCompareCriterion {
    public LtCriterion(String propName, Comparable<?> value) {
        super(propName, value);
        setOperator(" < ");
    }
}