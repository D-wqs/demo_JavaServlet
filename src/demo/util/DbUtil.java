package demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	public static Connection getConnection(){
		Connection conn =null;
		//注册驱动类
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			//获取连接
			//获取连接参数
			String url = "jdbc:mysql://localhost:3306/crud?useUnicode=true&characterEncoding=utf8";
			String username ="root";
			String password="root";
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//关闭连接
}
