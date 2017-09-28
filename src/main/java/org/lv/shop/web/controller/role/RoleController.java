package org.lv.shop.web.controller.role;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.lv.shop.entity.role.Role;
import org.lv.shop.service.role.RoleService;
import org.lv.shop.util.JsonUtil;
import org.lv.shop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"role"})
public class RoleController
{

  @Autowired
  private RoleService roleService;
  private Page page = new Page();

  public Page getPage()
  {
    return this.page;
  }

  public void setPage(Page page) {
    this.page = page;
  }

  @RequestMapping({"getRoleListPage"})
  public String getRoleListPage()
  {
    return "role/role_list_page";
  }

  @RequestMapping({"getRoleList"})
  public void getRoleList(Role role, Integer offset, Integer limit, HttpServletResponse response)
  {
      this.page.setStrat(offset);
      this.page.setPagecount(limit);
      this.page.setObj(role);
      this.roleService.getRoleList(this.page);
      Map map = new HashMap();
      map.put("total", this.page.getPagesumcount());
      map.put("rows", this.page.getList());
      JsonUtil.outJson(map, response);
  }

  @RequestMapping({"addRolePage"})
  public String addRolePage()
  {
    return "role/role_add_page";
  }

  @RequestMapping({"insertRole"})
  public String insertRole(Role role)
  {
      roleService.insertRole(role);
    return "redirect:/role/getRoleListPage.gang";
  }
}