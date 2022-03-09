package com.ghs.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ghs.server.pojo.AdminCourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
}
