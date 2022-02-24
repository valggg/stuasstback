package com.ghs.server.controller;


import com.ghs.server.pojo.Course;
import com.ghs.server.pojo.RespBean;
import com.ghs.server.service.ICourseService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ghs
 * @since 2022-02-24
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @ApiModelProperty(value = "通过用户id查询课程表")
    @GetMapping("/showTab")
    public List<Course> getCoursesByAdminId(){
        return courseService.getCoursesByAdminId();
    }

    @ApiOperation(value = "添加课程")
    @PostMapping("/")
    public RespBean addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @ApiOperation(value = "删除课程")
    @PostMapping("/{id}")
    public RespBean deleteCourse(@PathVariable Integer id){
        return courseService.deleteCourse(id);
    }

}
