package cn.dz.user.service;

import java.sql.SQLException;
import java.util.List;

import cn.dz.user.dao.PageDao;
import cn.dz.user.dao.PageDaoImpl;
import cn.dz.user.domain.Page;
import cn.dz.user.domain.User;

public class PageServiceImpl implements PageService {
	private PageDao pageDao = new PageDaoImpl();

	@Override
	public Page findPage(int page, int count) {
		try {
			List<User> users = pageDao.findUsers(page, count);
			System.out.println(users);
			int total = pageDao.count();
			System.out.println(total);
			Page p = new Page();
			p.setUsers(users);
			p.setCurrentPage(page);
			p.setCount(count);
			p.setTotalCount(total);
			int totalPage = total % count == 0 ? total / count : (total / count) + 1;
			p.setTotalPage(totalPage);
			return p;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
