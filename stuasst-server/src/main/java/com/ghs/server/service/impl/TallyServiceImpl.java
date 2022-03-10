package com.ghs.server.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ghs.server.mapper.AdminTallyMapper;
import com.ghs.server.mapper.TallyMapper;
import com.ghs.server.pojo.*;
import com.ghs.server.service.ITallyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ghs
 * @since 2022-03-06
 */
@Service
public class TallyServiceImpl extends ServiceImpl<TallyMapper, Tally> implements ITallyService {

    @Autowired
    private TallyMapper tallyMapper;
    @Autowired
    private AdminTallyMapper adminTallyMapper;


    /**
     * 通过用户id查询账单
     * @return
     */
    @Override
    public List<Tally> getTallyByAdminId() {
        Integer adminId = ((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        return tallyMapper.getTallies(adminId);
    }

    /**
     * 添加账单
     * @param tally
     * @return
     */
    @Override
    public RespBean addTally(Tally tally) {
        tallyMapper.addTally(tally);
        Integer adminId = ((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        if (1 == tally.getResult()){
            AdminTally adminTally = new AdminTally();
            adminTally.setId(0);
            adminTally.setAdminId(adminId);
            adminTally.setTid(tally.getReId());
            adminTallyMapper.addAdminTally(adminTally);
            return RespBean.success("添加成功",tally);
        }
        return RespBean.error("添加失败，请稍后再试！");
    }

    @Override
    public List<Tally> getInAndOutByAdminId(boolean isIncome) {
        Integer adminId = ((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        return tallyMapper.getInAndOut(adminId,isIncome);
    }

    /**
     * 分页获取账单
     * @param currentPage
     * @param size
     * @return
     */
    @Override
    public RespPageBean getTallyByPage(Integer currentPage, Integer size) {
        Integer adminId = ((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        //开启分页
        Page<Tally> page = new Page<>(currentPage, size);
        IPage<Tally> tallyIPage = tallyMapper.getTallyByPage(adminId,page);
        RespPageBean respPageBean = new RespPageBean(tallyIPage.getTotal(), tallyIPage.getRecords());
        return respPageBean;
    }
}
