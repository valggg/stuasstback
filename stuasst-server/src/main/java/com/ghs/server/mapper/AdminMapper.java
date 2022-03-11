package com.ghs.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ghs.server.pojo.Admin;
import com.ghs.server.pojo.AdminSignUpParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ghs
 * @since 2022-02-11
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

    /**
     * 获取所有操作员
     * @param keywords
     * @return
     */
    List<Admin> getAllAdmins(@Param("id") Integer id, @Param("keywords") String keywords);

    /**
     * 注册
     * @param adminSignUpParam
     */
    void signUp(AdminSignUpParam adminSignUpParam);
}
