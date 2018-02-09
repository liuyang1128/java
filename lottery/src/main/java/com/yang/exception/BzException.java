package com.yang.exception;

/**
 * 基础异常类
 *
 * Package:com.yixin.ndss.utils.exception
 *
 * @author YixinCapital -- Yang.Liu
 *         2018/1/26 11:05
 */
public class BzException extends RuntimeException {

    /**
     *
     * @author YixinCapital -- wujt 2016年9月30日 下午1:37:30
     *
     */
    private static final long serialVersionUID = 1L;

    public BzException() {
    }

    public BzException(String message) {
        super(message);
    }

    public BzException(Throwable cause) {
        super(cause);
    }

    public BzException(String message, Throwable cause) {
        super(message, cause);
    }
}
