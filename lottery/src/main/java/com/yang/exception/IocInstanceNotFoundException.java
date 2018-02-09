package com.yang.exception;

/**
 * Package:com.yixin.ndss.utils.exception
 *
 * @author YixinCapital -- Yang.Liu
 *         2018/1/26 9:31
 */
public class IocInstanceNotFoundException extends IocException {
    private static final long serialVersionUID = -742775077430352894L;

    public IocInstanceNotFoundException() {
    }

    public IocInstanceNotFoundException(String message) {
        super(message);
    }

    public IocInstanceNotFoundException(Throwable cause) {
        super(cause);
    }

    public IocInstanceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
