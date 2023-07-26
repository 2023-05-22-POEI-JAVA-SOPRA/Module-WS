package fr.maboite.correction.service;

import java.util.List;

import fr.maboite.correction.jpa.dao.RoleDAO;
import fr.maboite.correction.jpa.entity.Roles;

public class RoleService {
	
	private RoleDAO roleDao = new RoleDAO();

	/**
	 * Sauvegarde (insère ou met à jour) user.
	 * 
	 * @param user
	 * @return
	 */
	public Roles save(Roles role) {
		if(role.getId() == null)
		{
			return this.roleDao.save(role);
		}
		else return null;
		
	}

	/**
	 * Renvoie le User ayant id, peut renvoyer null.
	 * 
	 * @param id
	 * @return
	 */
	public Roles get(Integer id) {
		return this.roleDao.getById(id);
	}

	/**
	 * Renvoie tous les Users en base de données.
	 * 
	 * @return
	 */
	public List<Roles> findAll() {
		return this.roleDao.getAll();
	}
	
}
