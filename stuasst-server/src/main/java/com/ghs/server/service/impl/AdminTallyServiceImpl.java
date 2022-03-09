package com.ghs.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ghs.server.mapper.AdminTallyMapper;
import com.ghs.server.pojo.AdminTally;
import com.ghs.server.service.IAdminTallyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ghs
 * @since 2022-03-06
 */
@Service
public class AdminTallyServiceImpl extends ServiceImpl<AdminTallyMapper, AdminTally> implements IAdminTallyService {

    @Autowired
    private AdminTallyMapper adminTallyMapper;
    /**
     * 删除账单
     * @param tid
     */
    @Override
    public void delAdminTallyByTid(Integer tid) {
        adminTallyMapper.delAdminTallyByTid(tid);
    }
}
