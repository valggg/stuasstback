package com.ghs.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ghs.server.pojo.Course;
import com.ghs.server.pojo.RespBean;
import com.ghs.server.pojo.Tab;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ghs
 * @since 2022-03-02
 */
public interface ITabService extends IService<Tab> {

    /**
     * 根据用户id获取课程表信息
     * @param adminId
     * @return
     */
    List<Tab> getTabByAdminId(Integer adminId);

    /**
     * 新建课程表
     * @param tab
     * @return
     */
    RespBean addTab(Tab tab);
}
