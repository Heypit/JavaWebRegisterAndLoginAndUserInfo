package cn.dz.user.service;

/**
 * 自定义一个异常类
 * 给出父类的构造器即可，方便用来创建对象
 * @author Administrator
 *
 */
public class UserException extends Exception {

	public UserException() {
		super();
	}

	public UserException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserException(String message) {
		super(message);
	}

	public UserException(Throwable cause) {
		super(cause);
	}

}
