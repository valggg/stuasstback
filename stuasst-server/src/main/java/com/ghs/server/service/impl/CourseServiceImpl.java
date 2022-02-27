package com.ghs.server.service.impl;

import com.ghs.server.pojo.Admin;
import com.ghs.server.pojo.Course;
import com.ghs.server.mapper.CourseMapper;
import com.ghs.server.pojo.RespBean;
import com.ghs.server.service.ICourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ghs
 * @since 2022-02-24
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

    @Autowired
    private CourseMapper courseMapper;
    /**
     * 通过用户id查询课程表
     * @return
     */
    @Override
    public List<Course> getCoursesByAdminId() {
        Integer adminId = ((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        return courseMapper.getCourses(adminId);
    }

    /**
     * 添加课程
     * @param course
     * @return
     */
    @Override
    public RespBean addCourse(Course course) {
        courseMapper.addCourse(course);
        if (1 == course.getResult()){
            return RespBean.success("添加成功",course);
        }
        return RespBean.error("添加失败，请稍后再试！");
    }

//    /**
//     * 删除课程
//     * @param id
//     * @return
//     */
//    public RespBean deleteCourse(Integer id){
//        Course course = new Course();
//        course.setId(id);
//        courseMapper.deleteCourse(course);
//        if (1 == course.getResult()){
//            return RespBean.success("删除成功");
//        }
//        return RespBean.error("删除失败，请稍后再试！");
//    }

}
