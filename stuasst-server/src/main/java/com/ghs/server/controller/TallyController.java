package com.ghs.server.controller;


import com.ghs.server.pojo.*;
import com.ghs.server.service.IAdminTallyService;
import com.ghs.server.service.ITallyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ghs
 * @since 2022-03-06
 */
@RestController
@RequestMapping("/tally")
public class TallyController {

    @Autowired
    private ITallyService tallyService;
    @Autowired
    private IAdminTallyService adminTallyService;

    @ApiOperation(value = "通过用户id查询账单")
    @GetMapping("/tooTally")
    public List<Tally> getTalliesByAdminId(){
        return tallyService.getTallyByAdminId();
    }

    @ApiOperation(value = "分页获取所有账单")
    @GetMapping("/")
    public RespPageBean getTallyByPage(@RequestParam(defaultValue = "1") Integer currentPage,
                                    @RequestParam(defaultValue = "10") Integer size) {
        return tallyService.getTallyByPage(currentPage, size);
    }

    @ApiOperation(value = "通过用户id查询支出/收入账单")
    @GetMapping("/tooTally/{isIncome}")
    public List<Tally> getInAndOutByAdminId(@PathVariable boolean isIncome){
        return tallyService.getInAndOutByAdminId(isIncome);
    }

    @ApiOperation(value = "添加账单")
    @PostMapping("/")
    public RespBean addTally(@RequestBody Tally tally){
        return tallyService.addTally(tally);
    }

    @ApiOperation(value = "删除账单")
    @DeleteMapping("/{id}")
    public RespBean deleteTally(@PathVariable Integer id){
        if (tallyService.removeById(id)) {
            adminTallyService.delAdminTallyByTid(id);
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation(value = "更新账单")
    @PutMapping("/")
    public RespBean updateTally(@RequestBody Tally tally){
        if (tallyService.updateById(tally)) {
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @ApiOperation(value = "批量删除账单")
    @DeleteMapping("/")
    public RespBean deleteTalliesByIds(Integer[] ids) {
        if(tallyService.removeByIds(Arrays.asList(ids))){
            for (int i = 0;i <= ids.length-1;i++){
                adminTallyService.delAdminTallyByTid(ids[i]);
            }

            return RespBean.success("批量删除账单成功！");
        }
        return RespBean.error("批量删除账单失败，请稍后再试！");
    }
}
