package com.ghs.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ghs.server.pojo.RespBean;
import com.ghs.server.pojo.Tally;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ghs
 * @since 2022-03-06
 */
@Mapper
public interface TallyMapper extends BaseMapper<Tally> {

    /**
     * 通过用户id查询账单
     * @param adminId
     * @return
     */
    List<Tally> getTallies(Integer adminId);

    /**
     * 添加账单
     * @param tally
     * @return
     */
    void addTally(Tally tally);

    /**
     * 通过用户id查询收入/支出账单
     * @param adminId
     * @param isIncome
     * @return
     */
    List<Tally> getInAndOut(@Param("adminId") Integer adminId,@Param("isIncome") boolean isIncome);
}
