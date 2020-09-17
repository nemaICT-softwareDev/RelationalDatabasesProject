package org.fontys.thelearningmachines.application.entity.role;

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
