package org.lv.shop.service.role;

import org.lv.shop.entity.role.Role;
import org.lv.shop.util.Page;

public abstract interface RoleService
{
  public abstract void getRoleList(Page paramPage);

  public abstract void insertRole(Role paramRole);
}