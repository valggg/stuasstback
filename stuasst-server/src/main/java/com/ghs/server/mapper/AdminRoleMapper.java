package com.ghs.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ghs.server.pojo.AdminRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 管理员角色中间表 Mapper 接口
 * </p>
 *
 * @author ghs
 * @since 2022-02-17
 */
@Mapper
public interface AdminRoleMapper extends BaseMapper<AdminRole> {

    /**
     * 更新操作员角色
     * @param adminId
     * @param rids
     * @return
     */
    Integer updateAdminRole(@Param("adminId") Integer adminId, @Param("rids") Integer[] rids);
}
