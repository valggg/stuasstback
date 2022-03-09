package com.ghs.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ghs.server.pojo.RespBean;
import com.ghs.server.pojo.Tab;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ghs
 * @since 2022-03-02
 */
@Mapper
public interface TabMapper extends BaseMapper<Tab> {

    /**
     * 通过用户id获取课程表信息
     * @param adminId
     * @return
     */
    Tab getTabByAdminId(Integer adminId);

    /**
     * 新建课程表
     * @param tab
     * @return
     */
    void addTab(Tab tab);
}
