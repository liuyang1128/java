package com.yang.core;

import java.io.Serializable;

/**
 * Package:com.yixin.ndss.assembler.common
 *
 * @author YixinCapital -- Yang.Liu
 *         2018/1/26 9:45
 */
public abstract interface Entity extends Serializable {
    public abstract Serializable getId();

    public abstract boolean existed();

    public abstract boolean notExisted();
}
