package demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.dao.SelectAllDao;
import demo.dao.impl.SelectAllDaoImpl;
import demo.pojo.Message;

public class Findall extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//������������ʽ����Ӧ�����ʽ
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		SelectAllDao dao=new SelectAllDaoImpl();
		//��ȡ������Դ·��
		String uri = req.getRequestURI();
		//����uri��ȡ������
		String action = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		System.out.println("--------------------"+action);
		//���ݲ�ͬ��������ִ�ж�Ӧ��ҵ��
		if("/list".equals(action)){
			try {
				List<Message> list1=dao.findAll();
				List<Message> list2=dao.findAll2();
				List<Message> list3=dao.findAll3();
				//����ѯ��������ת����emplist.jspҳ����ʾ
				//������
				req.setAttribute("list1", list1);
				req.setAttribute("list2", list2);
				req.setAttribute("list3", list3);
				//��ȡת����,Ȼ��ת��
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("/add".equals(action)) {
			//��ȡ�û����ݵĲ���
			String info = req.getParameter("info");
			int num = Integer.parseInt(req.getParameter("num"));
			System.out.println("num-->"+num);
			//ת����Message����
			Message m = new Message(info, num);
			//���浽���ݿ���
			try {
				dao.addMessage(m);;
				//��ӽ������ض���index.jsp
				resp.sendRedirect("list.do");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else if("/delete".equals(action)) {
			//��ȡ�û����ݵĲ���
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				dao.deleteMessage(id);
				//��ӽ������ض���index.jsp
				resp.sendRedirect("list.do");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else if("/load".equals(action)) {
			//��ȡ�û����ݵĲ���
			int id = Integer.parseInt(req.getParameter("id"));
			//����id��ѯ��info����ϸ��Ϣ
			try {
				Message m=dao.FindMessageById(id);
				//ת�����޸�ҳ��update.jsp
				req.setAttribute("message", m);
				//��ȡת������Ȼ��ת��
				req.getRequestDispatcher("update.jsp").forward(req, resp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else if("/update".equals(action)) {
			//��ȡ�û����ݵĲ���
			int id = Integer.parseInt(req.getParameter("id"));
			String info = req.getParameter("info");
			int num = Integer.parseInt(req.getParameter("num"));
			//ת����Message����
			Message m = new Message(id, info, num);
			//�������ݿ�����޸�
			try {
				dao.Update(m);
				//�޸Ľ������ض���emplist.jsp
				resp.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
