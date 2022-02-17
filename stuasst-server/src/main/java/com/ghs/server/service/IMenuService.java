package com.ghs.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ghs.server.pojo.Menu;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author ghs
 * @since 2022-02-11
 */
public interface IMenuService extends IService<Menu> {
    /**
     * 通过用户id查询菜单列表
     * @return
     */
    List<Menu> getMenusByAdminId();

    /**
     * 根据角色获取菜单列表
     * @return
     */
    List<Menu> getMenusWithRole();
}
