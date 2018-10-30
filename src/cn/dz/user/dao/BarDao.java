package cn.dz.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import cn.dz.user.domain.Bar;

public class BarDao {
	public static Connection con = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;

	public String query() {
		ArrayList<Bar> barArr = new ArrayList<Bar>();
		con = Conn.getConnection();
		String sql = "SELECT * FROM mydb.bar";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Bar bar = new Bar();
				bar.setName(rs.getString("name"));
				bar.setNum(rs.getInt("num"));
				barArr.add(bar);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String str = gson.toJson(barArr);
		return str;
	}
	
	public void update(String name,Integer num) {
		con = Conn.getConnection();
		String sql = "update mydb.bar set num='"+num+"' where name='"+name+"'";
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
