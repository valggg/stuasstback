package com.ghs.server.mapper;

import com.ghs.server.pojo.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ghs
 * @since 2022-02-24
 */
@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    /**
     * 根据用户id查询课程
     * @param adminId
     * @return
     */
    List<Course> getCourses(Integer adminId);

    /**
     *  添加课程
     * @param course
     */
    void addCourse(Course course);

//    /**
//     * 删除课程
//     * @param course
//     */
//    void deleteCourse(Course course);

}
