package demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	public static Connection getConnection(){
		Connection conn =null;
		//ע��������
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			//��ȡ����
			//��ȡ���Ӳ���
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
	
	//�ر�����
}
