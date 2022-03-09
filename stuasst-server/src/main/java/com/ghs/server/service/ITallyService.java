package com.ghs.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ghs.server.pojo.RespBean;
import com.ghs.server.pojo.Tally;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ghs
 * @since 2022-03-06
 */
public interface ITallyService extends IService<Tally> {

    /**
     * 通过用户id查询账单
     * @return
     */
    List<Tally> getTallyByAdminId();

    /**
     * 添加账单
     * @param tally
     * @return
     */
    RespBean addTally(Tally tally);

    /**
     * 通过用户id查询收入/支出账单
     * @return
     */
    List<Tally> getInAndOutByAdminId(boolean isIncome);

}
