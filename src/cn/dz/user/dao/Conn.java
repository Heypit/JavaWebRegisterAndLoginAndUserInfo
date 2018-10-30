
package cn.dz.user.dao;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Conn {
	static String url = null;
	static String user = null;
	static String password = null;
	static String driverClass = null;
	
	static{
		try {
			
			Properties properties = new Properties();
			InputStream in = Conn.class.getResourceAsStream("/db.properties");
			properties.load(in);
			
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			driverClass = properties.getProperty("driverClass");
			
			Class.forName(driverClass);
			System.out.println("连接数据库成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("驱动加载失败！");
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnection(){
		try {
			Connection conn = (Connection) DriverManager.getConnection(url, user, password);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	} 
	
	public static void close(Connection conn,Statement st,ResultSet rs){
		if(conn!=null){
			try{
				conn.close();
			}catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
		if(st!=null){
			try{
				st.close();
			}catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
		if(rs!=null){
			try{
				rs.close();
			}catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public static void close(Connection conn,Statement st){
		if(conn!=null){
			try{
				conn.close();
			}catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
		if(st!=null){
			try{
				st.close();
			}catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

}
