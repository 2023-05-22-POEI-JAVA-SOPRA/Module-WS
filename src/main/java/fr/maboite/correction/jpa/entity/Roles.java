package fr.maboite.correction.jpa.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "t_roles")
public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idrole")
	private Integer id;
	
	@NotNull
	@Size(max = 20)
	private String roleName;

	/**
	 * Non argument constructor
	 */
	public Roles() {}
	
	/**
	 * @param roleName
	 */
	public Roles(@NotNull @Size(max = 20) String roleName) {
		this.roleName = roleName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
