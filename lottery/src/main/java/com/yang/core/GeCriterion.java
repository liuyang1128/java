/**
 * 2018年1月29日
 * Yang.Liu
 */
package com.yang.core;

/**
 * Package : com.yang.core
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月29日 上午11:13:40
 *
 */
public class GeCriterion extends ValueCompareCriterion {
    public GeCriterion(String propName, Comparable<?> value) {
        super(propName, value);
        setOperator(" >= ");
    }
}