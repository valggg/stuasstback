package com.ghs.server.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.ghs.server.pojo.Admin;
import com.ghs.server.pojo.AdminSignUpParam;
import com.ghs.server.pojo.RespBean;
import com.ghs.server.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "SignUpController")
@RestController
public class SignUpController {
    @Autowired
    private IAdminService adminService;

    @ApiOperation(value = "用户注册")
    @PostMapping("/signUp")
    private RespBean signUp(@RequestBody AdminSignUpParam adminSignUpParam){
        return adminService.signUp(adminSignUpParam.getUsername(),adminSignUpParam.getPassword());
    }
}
