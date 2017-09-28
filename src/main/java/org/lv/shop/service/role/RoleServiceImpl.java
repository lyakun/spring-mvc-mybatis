package org.lv.shop.service.role;

import java.util.List;
import java.util.UUID;
import org.lv.shop.entity.role.Role;
import org.lv.shop.mapper.role.RoleMapper;
import org.lv.shop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl
  implements RoleService
{

  @Autowired
  private RoleMapper roleMapper;

  public void getRoleList(Page page)
  {
    List roleList = roleMapper.getRoleList(page);
    int count = roleMapper.getRoleListCount(page);
    page.setList(roleList);
    page.setPagecount(Integer.valueOf(count));
  }

  public void insertRole(Role role)
  {
    role.setRoleId(UUID.randomUUID().toString());
    this.roleMapper.insertRole(role);
  }
}