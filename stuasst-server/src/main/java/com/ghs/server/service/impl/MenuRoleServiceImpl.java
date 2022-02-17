package com.ghs.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ghs.server.mapper.MenuRoleMapper;
import com.ghs.server.pojo.MenuRole;
import com.ghs.server.service.IMenuRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单角色中间表 服务实现类
 * </p>
 *
 * @author ghs
 * @since 2022-02-17
 */
@Service
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements IMenuRoleService {

}
