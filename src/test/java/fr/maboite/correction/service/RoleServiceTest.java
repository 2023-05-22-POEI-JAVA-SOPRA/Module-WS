package fr.maboite.correction.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import fr.maboite.correction.jpa.entity.Role;

public class RoleServiceTest {

    RoleService roleService = new RoleService();

    @Test
    public void get_role_with_non_existing_id() {
        assertNull(roleService.get(500000));
    }

    @Test
    public void get_role_with_existing_id() {
        Role role = new Role();
        role.setName("ADMIN");
        role.setIdRole(1);
        Role savedRole = roleService.get(1);
        assertEquals(role.getName(), savedRole.getName());
    }
    
    @Test
    public void save_role_with_null_name() {
        Role role = new Role();
        role.setIdRole(7);
        role.setName(null);

        assertNull(roleService.save(role));
    }
}

