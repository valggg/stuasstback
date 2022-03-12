package com.ghs.server.controller;


import com.ghs.server.pojo.Course;
import com.ghs.server.pojo.RespBean;
import com.ghs.server.pojo.Tab;
import com.ghs.server.service.IAdminCourseService;
import com.ghs.server.service.ICourseService;
import com.ghs.server.service.ITabService;
import com.ghs.server.service.impl.CourseServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ghs
 * @since 2022-03-02
 */
@RestController
@RequestMapping("/tab")
public class TabController {
    @Autowired
    private ITabService tabService;
    @Autowired
    private ICourseService courseService;
    @Autowired
    private IAdminCourseService adminCourseService;


    @ApiOperation(value = "通过用户id查询课程表信息")
    @GetMapping("/{id}")
    public Tab getTabByAdminId(@PathVariable Integer id){
        return tabService.getTabByAdminId(id);
    }

    @ApiOperation(value = "新建课程表")
    @PostMapping("/")
    public RespBean addTab(@RequestBody Tab tab){
        return tabService.addTab(tab);
    }

    @ApiOperation(value = "删除课程表")
    @DeleteMapping("/{id}")
    public RespBean deleteTab(@PathVariable Integer id){
        if (tabService.removeById(id)) {
            courseService.delCourseByAdminId();
            adminCourseService.delCoursesByAdminId();
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation(value = "更新课程表")
    @PutMapping("/")
    public RespBean updateTab(@RequestBody Tab tab){
        if (tabService.updateById(tab)) {
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

}
