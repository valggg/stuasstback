package com.ghs.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ghs.server.mapper.AdminCourseMapper;
import com.ghs.server.pojo.Admin;
import com.ghs.server.pojo.AdminCourse;
import com.ghs.server.pojo.RespBean;
import com.ghs.server.service.IAdminCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ghs
 * @since 2022-03-02
 */
@Service
public class AdminCourseServiceImpl extends ServiceImpl<AdminCourseMapper, AdminCourse> implements IAdminCourseService {

    @Autowired
    private AdminCourseMapper adminCourseMapper;




    @Override
    public void delAdminCourseByCid(Integer cid) {
        adminCourseMapper.delAdminCourseByCid(cid);
    }

    /**
     * 根据adminId删除用户-课程关系
     */
    public void delCoursesByAdminId(){
        Integer adminId = ((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        adminCourseMapper.delCoursesByAdminId(adminId);
    }
}
