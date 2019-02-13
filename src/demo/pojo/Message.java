package demo.pojo;

import java.io.Serializable;

public class Message implements Serializable{
	private int id;
	private String info;
	private int num;
	
	public Message(int id, String info, int num) {
		super();
		this.id = id;
		this.info = info;
		this.num = num;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", info=" + info + ", num=" + num + "]";
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(int id, String info) {
		super();
		this.id = id;
		this.info = info;
	}
	public Message(String info, int num) {
		super();
		this.info = info;
		this.num = num;
	}
	
}
