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
		//设置请求编码格式与响应编码格式
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		SelectAllDao dao=new SelectAllDaoImpl();
		//获取请求资源路径
		String uri = req.getRequestURI();
		//解析uri获取请求名
		String action = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		System.out.println("--------------------"+action);
		//根据不同的请求名执行对应的业务
		if("/list".equals(action)){
			try {
				List<Message> list1=dao.findAll();
				List<Message> list2=dao.findAll2();
				List<Message> list3=dao.findAll3();
				//将查询到得数据转发到emplist.jsp页面显示
				//绑定数据
				req.setAttribute("list1", list1);
				req.setAttribute("list2", list2);
				req.setAttribute("list3", list3);
				//获取转发器,然后转发
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("/add".equals(action)) {
			//获取用户传递的参数
			String info = req.getParameter("info");
			int num = Integer.parseInt(req.getParameter("num"));
			System.out.println("num-->"+num);
			//转换成Message对象
			Message m = new Message(info, num);
			//保存到数据库中
			try {
				dao.addMessage(m);;
				//添加结束后，重定向到index.jsp
				resp.sendRedirect("list.do");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else if("/delete".equals(action)) {
			//获取用户传递的参数
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				dao.deleteMessage(id);
				//添加结束后，重定向到index.jsp
				resp.sendRedirect("list.do");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else if("/load".equals(action)) {
			//获取用户传递的参数
			int id = Integer.parseInt(req.getParameter("id"));
			//根据id查询该info的详细信息
			try {
				Message m=dao.FindMessageById(id);
				//转发到修改页面update.jsp
				req.setAttribute("message", m);
				//获取转发器，然后转发
				req.getRequestDispatcher("update.jsp").forward(req, resp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else if("/update".equals(action)) {
			//获取用户传递的参数
			int id = Integer.parseInt(req.getParameter("id"));
			String info = req.getParameter("info");
			int num = Integer.parseInt(req.getParameter("num"));
			//转换成Message对象
			Message m = new Message(id, info, num);
			//传入数据库进行修改
			try {
				dao.Update(m);
				//修改结束后，重定向到emplist.jsp
				resp.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
