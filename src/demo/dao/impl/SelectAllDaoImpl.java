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
		//����һ������
		List<Message> list=new ArrayList<Message>();
		// TODO Auto-generated method stub
		//��ȡ����
		Connection conn = DbUtil.getConnection();
		//����sql���
		String sql = "select * from wjx where num=1";
		//����statement����
		PreparedStatement ps = conn.prepareStatement(sql);
		//ִ��sql,��ȡ�����
	 	ResultSet rs= ps.executeQuery();
		//�������������������ÿһ������ת����message������ӵ�list������
		while(rs.next()){
			//ȡ��ѯ����������ձ��ֶε�˳����ֶ�����ȡ
			int id = rs.getInt("id");
			String info = rs.getString(2);
			//����ȡ���ñ���ת����message����
			Message m=new Message(id, info);
			System.out.println("��ѯ���ģ�"+m.toString());
			//��ӵ�list������
			list.add(m);
		}
		return list;
	}

	@Override
	public List<Message> findAll2() throws Exception {
		//����һ������
		List<Message> list=new ArrayList<Message>();
		// TODO Auto-generated method stub
		//��ȡ����
		Connection conn = DbUtil.getConnection();
		//����sql���
		String sql = "select * from wjx where num=2";
		//����statement����
		PreparedStatement ps = conn.prepareStatement(sql);
		//ִ��sql,��ȡ�����
	 	ResultSet rs= ps.executeQuery();
		//�������������������ÿһ������ת����message������ӵ�list������
		while(rs.next()){
			//ȡ��ѯ����������ձ��ֶε�˳����ֶ�����ȡ
			int id = rs.getInt("id");
			String info = rs.getString(2);
			//����ȡ���ñ���ת����message����
			Message m=new Message(id, info);
			System.out.println("��ѯ���ģ�"+m.toString());
			//��ӵ�list������
			list.add(m);
		}
		return list;
	}

	@Override
	public List<Message> findAll3() throws Exception {
		//����һ������
		List<Message> list=new ArrayList<Message>();
		// TODO Auto-generated method stub
		//��ȡ����
		Connection conn = DbUtil.getConnection();
		//����sql���
		String sql = "select * from wjx where num=3";
		//����statement����
		PreparedStatement ps = conn.prepareStatement(sql);
		//ִ��sql,��ȡ�����
	 	ResultSet rs= ps.executeQuery();
		//�������������������ÿһ������ת����message������ӵ�list������
		while(rs.next()){
			//ȡ��ѯ����������ձ��ֶε�˳����ֶ�����ȡ
			int id = rs.getInt("id");
			String info = rs.getString(2);
			//����ȡ���ñ���ת����message����
			Message m=new Message(id, info);
			System.out.println("��ѯ���ģ�"+m.toString());
			//��ӵ�list������
			list.add(m);
		}
		return list;
	}

	@Override
	public void addMessage(Message m) throws Exception {
		// TODO Auto-generated method stub
		//��ȡ����
		Connection conn =DbUtil.getConnection();
		String sql ="insert into wjx(info,num) values(?,?)";
		//��ȡstatement����
		PreparedStatement ps= conn.prepareStatement(sql);
		//����?��ֵ
		ps.setString(1, m.getInfo());
		ps.setInt(2, m.getNum());
		//ִ��sql
		ps.execute();
	}

	@Override
	public void deleteMessage(int id) throws Exception {
		// TODO Auto-generated method stub
		//��ȡ����
		Connection conn =DbUtil.getConnection();
		String sql ="delete from wjx where id=?";
		//��ȡstatement����
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setLong(1, id);
		ps.executeUpdate();
	}

	@Override
	public Message FindMessageById(int id) throws Exception {
		// TODO Auto-generated method stub
		Message m = null;
		//��ȡ����
		Connection conn =DbUtil.getConnection();
		//����sql���
		String sql = "select * from wjx where id=?";
		//����statement����
		PreparedStatement ps = conn.prepareStatement(sql);
		//����ֵ
		ps.setLong(1, id);
		//��ȡ�����
		ResultSet rs = ps.executeQuery();
		//���������
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
		//��ȡ����
		Connection conn = DbUtil.getConnection();
		//����sql���
		String sql = "update wjx set info=?,num=? where id=?";
		//����statement����
		PreparedStatement ps = conn.prepareStatement(sql);
		//����ֵ
		ps.setString(1, m.getInfo());
		ps.setInt(2, m.getNum());
		ps.setInt(3, m.getId());
		//�ύ�޸�
		ps.executeUpdate();
	}

}
