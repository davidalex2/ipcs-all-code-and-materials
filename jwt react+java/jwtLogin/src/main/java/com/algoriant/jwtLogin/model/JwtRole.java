package com.algoriant.jwtLogin.model;

import javax.persistence.*;


@Entity
@Table(name = "roles")
public class JwtRole {

    @Id
    @Column(name = "role_")
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "role_desc")
    private String roleDesc;


    public JwtRole() {
    }

    public JwtRole(String role) {
        this.role = Role.valueOf(role);
    }

    public String getRole() {
        return String.valueOf(role);
    }

    public void setRole(String role) {
        this.role = Role.valueOf(role);
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
    @Override
    public String toString() {
        return String.valueOf(this.role);
    }
}
