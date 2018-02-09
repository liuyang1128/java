/**
 * 2018年1月29日
 * Yang.Liu
 */
package com.yang.core.criterionBase;

/**
 * Package : com.yang.core
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月29日 上午10:39:46
 *
 */
public abstract class BasicCriterion extends AbstractCriterion {
    private final String propName;

    public BasicCriterion(String propName) {
        this.propName = propName;
    }

    public String getPropName() {
        return this.propName;
    }

    protected String getPropNameWithAlias() {
        return "rootEntity." + this.propName;
    }

    protected String getParamName() {
        String result = "rootEntity_" + this.propName + hashCode();
        result = result.replace(".", "_");
        result = result.replace("-", "_");
        return result;
    }

    protected String getParamNameWithColon() {
        return ":" + getParamName();
    }
}