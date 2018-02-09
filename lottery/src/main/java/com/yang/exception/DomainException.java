/**
 * 2018年1月27日
 * Yang.Liu
 */
package com.yang.exception;

/**
 * Package : com.yixin.lottery.exception
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月27日 下午2:22:27
 *
 */
public class DomainException extends RuntimeException {

	/**
	 * 
	 * @author YixinCapital -- Yang.Liu
	 *		   2018年1月27日 下午2:22:48
	 *
	 */
	private static final long serialVersionUID = -5567625676545355904L;

	/**
	 *  无参构造
	 * @author YixinCapital -- yangysh
	 *	       2017年6月2日 下午4:55:20
	 */
	public DomainException() {
		super();
	}

	/**
	 * 包含错误信息的异常的构造
	 * @param message 错误信息
	 * @param err 异常的实例
	 * @author YixinCapital -- yangysh
	 *	       2017年6月2日 下午4:55:31
	 */
	public DomainException(String message, Throwable err) {
		super(message, err);
	}

	/**
	 * 包含错误信息的构造
	 * @param message 错误信息
	 * @author YixinCapital -- yangysh
	 *	       2017年6月2日 下午4:55:51
	 */
	public DomainException(String message) {
		super(message);
	}

	/**
	 * 仅包含异常实例的构造
	 * @param err 异常实例
	 * @author YixinCapital -- yangysh
	 *	       2017年6月2日 下午4:56:18
	 */
	public DomainException(Throwable err) {
		super(err);
	}
}
