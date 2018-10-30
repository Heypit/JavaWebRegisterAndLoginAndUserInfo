package cn.dz.user.domain;

import java.util.List;

public class Page {
	private int currentPage;//当前页
    private int totalPage;//总页数
    private int count;//一页多少条数据
    private List<User> users;//当前页的图书数据
    private int totalCount;//数据总条数
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	@Override
	public String toString() {
		return "Page [currentPage=" + currentPage + ", totalPage=" + totalPage + ", count=" + count + ", users=" + users
				+ ", totalCount=" + totalCount + "]";
	}
    
}
