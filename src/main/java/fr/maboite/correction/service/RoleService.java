package fr.maboite.correction.service;


import fr.maboite.correction.jpa.dao.RoleDao;
import fr.maboite.correction.jpa.entity.Role;

/**
 * Classe de service pour les Role
 */
public class RoleService {
	
	private RoleDao roleDao = new RoleDao();

	/**
	 * Sauvegarde (insère ou met à jour) user.
	 * 
	 * @param role
	 * @return
	 */
	public Role save(Role role) {
		return this.roleDao.save(role);
	}

	/**
	 * Renvoie le User ayant id, peut renvoyer null.
	 * 
	 * @param id
	 * @return
	 */
	public Role get(Integer id) {
		return this.roleDao.get(id);
	}

}
	

	