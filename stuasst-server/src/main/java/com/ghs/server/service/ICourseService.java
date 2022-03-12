package com.ghs.server.service;

import com.ghs.server.pojo.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ghs.server.pojo.Menu;
import com.ghs.server.pojo.RespBean;

import java.util.List;

/**
 * <p>
 *  课程表 服务类
 * </p>
 *
 * @author ghs
 * @since 2022-02-24
 */
public interface ICourseService extends IService<Course> {
    /**
     * 通过用户id查询课程
     * @return
     */
    List<Course> getCoursesByAdminId();

    /**
     * 添加课程
     * @param course
     * @return
     */
    RespBean addCourse(Course course);

    /**
     * 通过adminId删除课程
     */
    void delCourseByAdminId();

}
