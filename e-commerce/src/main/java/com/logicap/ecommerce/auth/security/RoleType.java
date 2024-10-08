package com.logicap.ecommerce.auth.security;

public enum RoleType {

  ADMIN, USER;

  private static final String ROLE_PREFIX = "ROLE_";

  public String getFullRoleName() {
    return ROLE_PREFIX + this.name();
  }

}