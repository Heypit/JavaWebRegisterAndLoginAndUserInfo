package cn.dz.user.dao;

import java.sql.SQLException;
import java.util.List;

import cn.dz.user.domain.User;

public interface PageDao {
	public List<User> findUsers(int page, int count) throws SQLException;

	public int count() throws SQLException;
}
