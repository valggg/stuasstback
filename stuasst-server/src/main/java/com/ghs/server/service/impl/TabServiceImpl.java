package com.ghs.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ghs.server.mapper.TabMapper;
import com.ghs.server.pojo.RespBean;
import com.ghs.server.pojo.Tab;
import com.ghs.server.service.ITabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ghs
 * @since 2022-03-02
 */
@Service
public class TabServiceImpl extends ServiceImpl<TabMapper, Tab> implements ITabService {


    @Autowired
    private TabMapper tabMapper;

    /**
     * 根据用户id获取课程表信息
     * @param adminId
     * @return
     */
    @Override
    public List<Tab> getTabByAdminId(Integer adminId) {
        return tabMapper.getTabByAdminId(adminId);
    }

    /**
     * 新建课程表
     * @param tab
     * @return
     */
    @Override
    public RespBean addTab(Tab tab) {
        return tabMapper.addTab(tab);
    }
}
