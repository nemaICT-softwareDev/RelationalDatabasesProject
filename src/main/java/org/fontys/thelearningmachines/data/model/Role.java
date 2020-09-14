package org.fontys.thelearningmachines.data.model;

import org.fontys.thelearningmachines.data.model.interfaces.RoleInterface;

public class Role implements RoleInterface {

    private String role;

    public Role() {
    }


    @Override
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getRole() {
        return role;
    }
}
