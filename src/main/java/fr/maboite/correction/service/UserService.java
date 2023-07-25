package fr.maboite.correction.service;

import java.util.List;

import fr.maboite.correction.jpa.dao.UserDao;
import fr.maboite.correction.jpa.entity.User;

public class UserService {
	
	private UserDao userDao = new UserDao();
	
	public User getById(Integer id) {
		return userDao.getById(id);
	}
	
	public List<User> getAll() {
		return userDao.getAll();
	}
	
	public boolean create(User user) {
		return userDao.create(user);
	}
	
	public boolean update(User user, Integer id) {
		return userDao.update(user, id);
	}
	
	public boolean delete(Integer id) {
		return userDao.delete(id);
	}
	

}
