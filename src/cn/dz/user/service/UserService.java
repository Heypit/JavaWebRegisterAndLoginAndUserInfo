package cn.dz.user.service;

import java.util.List;

import cn.dz.user.dao.UserDao;
import cn.dz.user.domain.User;

/**
 * User业务逻辑层
 * 
 * @author Day
 *
 */
public class UserService {
	private UserDao userDao = new UserDao();

	public void register(User user) throws UserException {
		/*
		 * 1.使用用户名去查询，如果返回null，完成添加 2.如果返回不是null，抛出异常
		 */
		User registerUser = userDao.findByname(user.getUsername());
		if (registerUser != null) {
			throw new UserException("用户名" + registerUser.getUsername() + ",已被注册过了");
		}
		userDao.add(user);
	}

	public User login(User form) throws UserException {
		User loginUser = userDao.findByname(form.getUsername());
		if (loginUser == null) {
			throw new UserException("用户名不存在！");
		}
		if (!form.getPassword().equals(loginUser.getPassword())) {
			throw new UserException("密码错误！");
		}
		/*
		 * 返回数据库中查询出来的user，而不是form！！！
		 */
		return loginUser;
	}

	public String find(User user) throws UserException {
		String tip = "../images/MsgSent.gif";
		User findUser = userDao.findByname(user.getUsername());
		if (findUser != null) {
			tip = "../images/MsgError.gif";
			// throw new UserException("用户名" + user.getUsername() + ",已被注册过了");
		}
		return tip;
	}

	public User administrate() throws UserException {
		User user1 = userDao.findByid(1);
		System.out.println(user1.toString());
		return user1;
	}
	
	/*public PageBean findAllUserWithPage(int pageNum,int pageSize){
		List<User> allUser=userDao.findAllUser();
		int totalRecord=allUser.size();
		PageBean pb=new PageBean(pageNum,pageSize,totalRecord);
		int startIndex=pb.getStartIndex();
		pb.setList(userDao.findAll(startIndex,pageSize));
		return pb;
	}*/
}
