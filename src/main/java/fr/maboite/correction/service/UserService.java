package fr.maboite.correction.service;

import java.util.List;

import fr.maboite.correction.jpa.dao.UserDao;
import fr.maboite.correction.jpa.entity.User;

/**
 * Classe de service pour les User
 */
public class UserService {
	
	private UserDao userDao = new UserDao();

	/**
	 * Sauvegarde (insère ou met à jour) user.
	 * 
	 * @param user
	 * @return
	 */
	public User save(User user) {
		
		if(user.getIdUser() == null)
		{
			return this.userDao.save(user);
		}
		else {
			return this.userDao.update(user);
		}
	}

	/**
	 * Renvoie le User ayant id, peut renvoyer null.
	 * 
	 * @param id
	 * @return
	 */
	public User get(Integer id) {
		return this.userDao.get(id);
	}

	/**
	 * Supprime l'user avec l'id id
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		this.userDao.delete(id);
	}

	/**
	 * Renvoie tous les Users en base de données.
	 * 
	 * @return
	 */
	public List<User> findAll() {
		return this.userDao.findAll();
	}
}
