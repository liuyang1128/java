/**
 * 2018年1月29日
 * Yang.Liu
 */
package com.yang.core;

/**
 * Package : com.yang.core
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月29日 上午10:38:43
 *
 */
public class EqCriterion extends ValueCompareCriterion {
    public EqCriterion(String propName, Object value) {
        super(propName, value);
        setOperator(" = ");
    }
}