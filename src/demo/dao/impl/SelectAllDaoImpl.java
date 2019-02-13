package demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import demo.dao.SelectAllDao;
import demo.pojo.Message;
import demo.util.DbUtil;

public class SelectAllDaoImpl implements SelectAllDao {

	@Override
	public List<Message> findAll() throws Exception {
		//创建一个集合
		List<Message> list=new ArrayList<Message>();
		// TODO Auto-generated method stub
		//获取连接
		Connection conn = DbUtil.getConnection();
		//创建sql语句
		String sql = "select * from wjx where num=1";
		//创建statement对象
		PreparedStatement ps = conn.prepareStatement(sql);
		//执行sql,获取结果集
	 	ResultSet rs= ps.executeQuery();
		//遍历结果集，将遍历的每一条数据转换成message对象并添加到list集合中
		while(rs.next()){
			//取查询结果集，按照表字段的顺序或按字段名获取
			int id = rs.getInt("id");
			String info = rs.getString(2);
			//将获取到得变量转换成message对象
			Message m=new Message(id, info);
			System.out.println("查询到的："+m.toString());
			//添加到list集合中
			list.add(m);
		}
		return list;
	}

	@Override
	public List<Message> findAll2() throws Exception {
		//创建一个集合
		List<Message> list=new ArrayList<Message>();
		// TODO Auto-generated method stub
		//获取连接
		Connection conn = DbUtil.getConnection();
		//创建sql语句
		String sql = "select * from wjx where num=2";
		//创建statement对象
		PreparedStatement ps = conn.prepareStatement(sql);
		//执行sql,获取结果集
	 	ResultSet rs= ps.executeQuery();
		//遍历结果集，将遍历的每一条数据转换成message对象并添加到list集合中
		while(rs.next()){
			//取查询结果集，按照表字段的顺序或按字段名获取
			int id = rs.getInt("id");
			String info = rs.getString(2);
			//将获取到得变量转换成message对象
			Message m=new Message(id, info);
			System.out.println("查询到的："+m.toString());
			//添加到list集合中
			list.add(m);
		}
		return list;
	}

	@Override
	public List<Message> findAll3() throws Exception {
		//创建一个集合
		List<Message> list=new ArrayList<Message>();
		// TODO Auto-generated method stub
		//获取连接
		Connection conn = DbUtil.getConnection();
		//创建sql语句
		String sql = "select * from wjx where num=3";
		//创建statement对象
		PreparedStatement ps = conn.prepareStatement(sql);
		//执行sql,获取结果集
	 	ResultSet rs= ps.executeQuery();
		//遍历结果集，将遍历的每一条数据转换成message对象并添加到list集合中
		while(rs.next()){
			//取查询结果集，按照表字段的顺序或按字段名获取
			int id = rs.getInt("id");
			String info = rs.getString(2);
			//将获取到得变量转换成message对象
			Message m=new Message(id, info);
			System.out.println("查询到的："+m.toString());
			//添加到list集合中
			list.add(m);
		}
		return list;
	}

	@Override
	public void addMessage(Message m) throws Exception {
		// TODO Auto-generated method stub
		//获取连接
		Connection conn =DbUtil.getConnection();
		String sql ="insert into wjx(info,num) values(?,?)";
		//获取statement对象
		PreparedStatement ps= conn.prepareStatement(sql);
		//设置?的值
		ps.setString(1, m.getInfo());
		ps.setInt(2, m.getNum());
		//执行sql
		ps.execute();
	}

	@Override
	public void deleteMessage(int id) throws Exception {
		// TODO Auto-generated method stub
		//获取连接
		Connection conn =DbUtil.getConnection();
		String sql ="delete from wjx where id=?";
		//获取statement对象
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setLong(1, id);
		ps.executeUpdate();
	}

	@Override
	public Message FindMessageById(int id) throws Exception {
		// TODO Auto-generated method stub
		Message m = null;
		//获取连接
		Connection conn =DbUtil.getConnection();
		//创建sql语句
		String sql = "select * from wjx where id=?";
		//创建statement对象
		PreparedStatement ps = conn.prepareStatement(sql);
		//设置值
		ps.setLong(1, id);
		//获取结果集
		ResultSet rs = ps.executeQuery();
		//遍历结果集
		while(rs.next()){
			m = new Message();
			m.setId(rs.getInt(1));
			m.setInfo(rs.getString(2));
			m.setNum(rs.getInt(3));
		}
		return m;
	}

	@Override
	public void Update(Message m) throws Exception {
		// TODO Auto-generated method stub
		//获取连接
		Connection conn = DbUtil.getConnection();
		//创建sql语句
		String sql = "update wjx set info=?,num=? where id=?";
		//创建statement对象
		PreparedStatement ps = conn.prepareStatement(sql);
		//设置值
		ps.setString(1, m.getInfo());
		ps.setInt(2, m.getNum());
		ps.setInt(3, m.getId());
		//提交修改
		ps.executeUpdate();
	}

}
