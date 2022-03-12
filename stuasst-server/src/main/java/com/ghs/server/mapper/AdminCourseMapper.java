package com.ghs.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ghs.server.pojo.AdminCourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ghs
 * @since 2022-03-02
 */
@Mapper
public interface AdminCourseMapper extends BaseMapper<AdminCourse> {

    /**
     * 添加用户-课程关系
     * @param adminCourse
     */
    void addAdminCourse(AdminCourse adminCourse);

    /**
     * 根据课程id删除用户-课程关系
     * @param cid
     */
    void delAdminCourseByCid(Integer cid);

    /**
     * 根据AdminId用户-课程关系
     * @param adminId
     */
    void delCoursesByAdminId(Integer adminId);

    /**
     * 查找所有
     */
    List<AdminCourse> findAll();
}
