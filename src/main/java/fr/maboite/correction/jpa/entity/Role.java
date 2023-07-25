package fr.maboite.correction.jpa.entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "T_Roles")
public class Role {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idrole")
	private Integer id;
	
	private String roleName;
	
//	@ManyToMany  
//	@Transient
//    @JoinTable( name = "T_Users_Roles_Associations",
//                joinColumns = @JoinColumn( name = "idRole" ),
//                inverseJoinColumns = @JoinColumn( name = "idUser" ) )
//	private List<User> users = new ArrayList<>();
//	
//	
//	public List<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}

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

//	public Role(String roleName, User user)
//	{
//		this.setRoleName(roleName);
//		this.setUser(user);;
//	}

	public Role(){
	}

	@Override
	public String toString() {
		 return "[" + this.roleName + "]";
	}

	public Role( String roleName, List<User> users) {
		super();
		this.roleName = roleName;
//		this.users = users;
	}

	
	
	
	
}
