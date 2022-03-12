package com.ghs.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ghs.server.pojo.AdminCourse;
import com.ghs.server.pojo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ghs
 * @since 2022-03-02
 */
public interface IAdminCourseService extends IService<AdminCourse> {

    /**
     * 根据课程id删除用户-课程关系
     * @param cid
     * @return
     */
    void delAdminCourseByCid(Integer cid);
    /**
     * 据课程adminId删除用户-课程关系
     */
    void delCoursesByAdminId();
}
