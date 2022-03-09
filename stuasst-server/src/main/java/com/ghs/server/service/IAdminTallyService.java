package com.ghs.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ghs.server.pojo.AdminTally;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ghs
 * @since 2022-03-06
 */
public interface IAdminTallyService extends IService<AdminTally> {

    /**
     * 删除账单
     * @param id
     */
    void delAdminTallyByTid(Integer tid);
}
