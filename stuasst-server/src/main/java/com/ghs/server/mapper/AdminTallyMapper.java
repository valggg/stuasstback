package com.ghs.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ghs.server.pojo.AdminTally;
import com.ghs.server.pojo.Tally;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ghs
 * @since 2022-03-06
 */
@Mapper
public interface AdminTallyMapper extends BaseMapper<AdminTally> {

    /**
     * 添加用户-账单关系
     * @param adminTally
     */
    void addAdminTally(AdminTally adminTally);

    /**
     * 删除用户-账单关系
     * @param tid
     */
    void delAdminTallyByTid(Integer tid);
}
