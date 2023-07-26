package fr.maboite.correction.service;

import java.util.List;

import fr.maboite.correction.jpa.dao.RoleDao;
import fr.maboite.correction.jpa.entity.Role;
import fr.maboite.correction.jpa.entity.Roles;

public class RoleService {
	
	private RoleDao roleDao = new RoleDao();

	/**
	 * Renvoie le User ayant id, peut renvoyer null.
=======
import fr.maboite.correction.jpa.dao.RoleDao;
import fr.maboite.correction.jpa.entity.Role;


public class RoleService {
	
	private RoleDao roleDao = new RoleDao();
	
	
	/**
	 * Renvoie le Role ayant id, peut renvoyer null.
	 * 
	 * @param id
	 * @return
	 */

	public Role get(Integer id) {
		return this.roleDao.get(id);
	}

	/**
	 * Renvoie tous les Users en base de données.
	 * 
	 * @return
	 */
	public List<Role> findAll() {
		return this.roleDao.findAll();
	}
	
	
	/**
	 * Sauvegarde (insère ou met à jour) role.
	 * 
	 * @param role
	 * @return
	 */
	public Role save(Role role) {
		return this.roleDao.save(role);
	}
}
