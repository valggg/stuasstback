package com.ghs.server.controller;


import com.ghs.server.pojo.Course;
import com.ghs.server.pojo.RespBean;
import com.ghs.server.pojo.Tab;
import com.ghs.server.service.IAdminCourseService;
import com.ghs.server.service.ICourseService;
import com.ghs.server.service.ITabService;
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
    @Autowired
    private ITabService tabService;
    @Autowired
    private IAdminCourseService adminCourseService;

    @ApiOperation(value = "通过用户id查询课程表信息")
    @GetMapping("/tab/{id}")
    public Tab getTabByAdminId(@PathVariable Integer id){
        return tabService.getTabByAdminId(id);
    }

    @ApiOperation(value = "新建课程表")
    @PostMapping("/tab/")
    public RespBean addTab(@RequestBody Tab tab){
        return tabService.addTab(tab);
    }

    @ApiOperation(value = "删除课程表")
    @DeleteMapping("/tab/{id}")
    public RespBean deleteTab(@PathVariable Integer id){
        if (tabService.removeById(id)) {
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation(value = "更新课程表")
    @PutMapping("/tab/")
    public RespBean updateTab(@RequestBody Tab tab){
        if (tabService.updateById(tab)) {
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @ApiOperation(value = "通过用户id查询课程")
    @GetMapping("/showCou")
    public List<Course> getCoursesByAdminId(){
        return courseService.getCoursesByAdminId();
    }

    @ApiOperation(value = "添加课程")
    @PostMapping("/")
    public RespBean addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @ApiOperation(value = "删除课程")
    @DeleteMapping("/{id}")
    public RespBean deleteCourse(@PathVariable Integer id){
        if (courseService.removeById(id)) {
            adminCourseService.delAdminCourseByCid(id);
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation(value = "更新课程")
    @PutMapping("/")
    public RespBean updateCourse(@RequestBody Course course){
        if (courseService.updateById(course)) {
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }


}

