package org.fontys.thelearningmachines.data.model;

import org.fontys.thelearningmachines.data.model.interfaces.RoleInterface;

public final class RoleModel implements RoleInterface {

    private String role;

    @Override
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getRole() {
        return role;
    }
}
