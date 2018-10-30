package cn.dz.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.dz.user.domain.User;

public class PageDaoImpl implements PageDao {
	public static Connection con = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;

	public List<User> findUsers(int page, int count) throws SQLException {
		con = Conn.getConnection();
		if (con == null) {
			throw new NullPointerException("con is null");
		}
		PreparedStatement ps = con.prepareStatement("SELECT id,username,password,province FROM mydb.user LIMIT ?,?");
		if (ps == null) {
			throw new NullPointerException("ps is null");
		}
		ps.setInt(1, (page - 1) * count);
		ps.setInt(2, count);
		ResultSet rs = ps.executeQuery();

		if (rs == null) {
			throw new NullPointerException("rs is null");
		}
		List<User> users = new ArrayList<>();
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt(1));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setProvince(rs.getString("province"));
			users.add(user);
		}
		return users;
	}

	public int count() throws SQLException {
		con = Conn.getConnection();
		if (con == null) {
			throw new NullPointerException("conn is null");
		}
		PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM mydb.user");
		if (ps == null) {
			throw new NullPointerException("ps is null");
		}
		ResultSet rs = ps.executeQuery();

		if (rs == null) {
			throw new NullPointerException("rs is null");
		}
		int count = 0;
		if (rs.next()) {
			count = rs.getInt(1);
		}
		return count;
	}

}
