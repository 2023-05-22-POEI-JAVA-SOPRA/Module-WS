package fr.maboite.correction.service;

import fr.maboite.correction.jpa.dao.UserDao;
import fr.maboite.correction.jpa.entity.User;

public class UserService {
	
	private UserDao userDao = new UserDao();

	public User save(User user) {
		return this.userDao.save(user);
	}

	public User get(Integer id) {
		return this.userDao.get(id);
	}

	public void delete(Integer id) {
		this.userDao.delete(id);
	}
}
