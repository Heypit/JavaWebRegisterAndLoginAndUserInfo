package cn.dz.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import cn.dz.user.domain.User;
import cn.itcast.jdbc.JdbcUtils;

/**
 * 
 * @author Day
 *
 */
public class UserDao {
	public static Connection con = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;

	private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());

	public void add(User user) {
		con = Conn.getConnection();
		String sql = "insert into user(username,password,province,city) values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			System.out.println(user.getPassword());
			System.out.println("UserDao里面的值：" + user.getProvince());
			System.out.println("UserDao里面的值：" + user.getCity());
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getProvince());
			ps.setString(4, user.getCity());
			// 执行插入语句，并返回一个int值，大于0表示添加成功，小于0表示添加失败.
			int b = ps.executeUpdate();
			if (b > 0) {
				System.out.println("数据添加成功");
			} else {
				System.out.println("数据添加失败");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public User findByname(String username) {
		con = Conn.getConnection();
		String sql = "select * from user where username=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next() == false) {
				return null;
			}
			Integer id = rs.getInt("id");
			String pwd = rs.getString("password");
			String province = rs.getString("province");
			User user = new User();
			user.setUsername(username);
			user.setPassword(pwd);
			user.setId(id);
			user.setProvince(province);
			System.out.println("查询成功");
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public User findByid(Integer id) {
		con = Conn.getConnection();
		String sql = "select * from user where id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next() == false) {
				return null;
			}

			String username = rs.getString("username");
			String pwd = rs.getString("password");
			String province = rs.getString("province");
			User user = new User();
			user.setUsername(username);
			user.setPassword(pwd);
			user.setProvince(province);
			System.out.println("查询成功");
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<User> findAllUser() {
		con = Conn.getConnection();
		String sql = "select * from user ";
		List<User> list = new ArrayList<User>();

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setProvince(rs.getString("province"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List findAll(int startIndex, int pageSize) {
		String sql = "select id,password,username,province from user limit ?,?";
		Object[] params = { startIndex, pageSize };
		List<User> users = null;
		try {
			users = qr.query(sql, new BeanListHandler<User>(User.class), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	
}

// @Test
// public void testFind() {
// // findByid(1).getPassword();
// System.out.println(findByid(1).getPassword());
// }
