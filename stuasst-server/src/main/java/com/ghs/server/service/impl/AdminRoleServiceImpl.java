package com.ghs.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ghs.server.mapper.AdminRoleMapper;
import com.ghs.server.pojo.AdminRole;
import com.ghs.server.service.IAdminRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员角色中间表 服务实现类
 * </p>
 *
 * @author ghs
 * @since 2022-02-17
 */
@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements IAdminRoleService {

}
