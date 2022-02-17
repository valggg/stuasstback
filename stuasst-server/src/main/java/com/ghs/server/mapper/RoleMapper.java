package com.ghs.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ghs.server.pojo.Role;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author ghs
 * @since 2022-02-17
 */
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 根据用户id查询角色列表
     * @return
     */
    List<Role> getRoles(Integer adminId);
}
