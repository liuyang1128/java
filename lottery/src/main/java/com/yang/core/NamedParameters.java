package com.yang.core;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Package:com.yixin.ndss.assembler.common.entity
 *
 * @author YixinCapital -- Yang.Liu
 *         2018/1/26 9:50
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class NamedParameters implements QueryParameters {
    private Map<String, Object> params = new HashMap();

    public static NamedParameters create() {
        return new NamedParameters(new HashMap());
    }

    public static NamedParameters create(Map<String, Object> params) {
        return new NamedParameters(params);
    }

    private NamedParameters(Map<String, Object> params) {
        Assert.notNull(params, "Parameters cannot be null");
        this.params = new HashMap(params);
    }

    public NamedParameters add(String key, Object value) {
        this.params.put(key, value);
        return this;
    }

    public NamedParameters add(NamedParameters other) {
        this.params.putAll(other.getParams());
        return this;
    }

    public Map<String, Object> getParams() {
        return Collections.unmodifiableMap(this.params);
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 43).append(this.params).toHashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NamedParameters)) {
            return false;
        }
        NamedParameters that = (NamedParameters) other;

        return new EqualsBuilder().append(getParams(), that.getParams()).isEquals();
    }

    public String toString() {
        return this.params.toString();
    }
}
