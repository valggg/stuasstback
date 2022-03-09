package com.ghs.server.controller;


import com.ghs.server.pojo.File;
import com.ghs.server.pojo.Tally;
import com.ghs.server.service.IFileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ghs
 * @since 2022-03-08
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private IFileService fileService;

    @ApiOperation(value = "通过用户id查询文件")
    @GetMapping("/fileList")
    public List<File> getFilesByAdminId(){
        return fileService.getFilesByAdminId();
    }

}
