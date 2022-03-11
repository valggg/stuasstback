package com.ghs.server.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 用户注册实体类
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "AdminSignUp对象",description = "")
public class AdminSignUpParam {
    @ApiModelProperty(value = "用户名", required = true)
    private String username;
    @ApiModelProperty(value = "密码", required = true)
    private String password;
    @ApiModelProperty(value = "名称", required = true)
    private String name;
    @ApiModelProperty(value = "头像", required = true)
    private String userFace;
    @ApiModelProperty(value = "是否可用", required = true)
    private boolean enabled;
    @ApiModelProperty(value = "返回结果，供存储过程使用")
    @TableField(exist = false)
    private Integer result;
    @ApiModelProperty(value = "返回插入id，供存储过程使用")
    @TableField(exist = false)
    private Integer reId;

}
