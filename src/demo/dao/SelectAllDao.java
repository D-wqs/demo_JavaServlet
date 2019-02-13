package demo.dao;

import java.util.List;

import demo.pojo.Message;

public interface SelectAllDao {
	List<Message> findAll() throws Exception;
	List<Message> findAll2() throws Exception;
	List<Message> findAll3() throws Exception;
	void addMessage(Message m) throws Exception;
	void deleteMessage(int id)throws Exception;
	Message FindMessageById(int id)throws Exception; 
	void Update(Message m)throws Exception;
}
