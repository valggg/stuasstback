package com.ghs.server.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ghs
 * @since 2022-03-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("s_admin_course")
@ApiModel(value="AdminCourse对象", description="")
public class AdminCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "用户id")
    private Integer adminId;

    @ApiModelProperty(value = "课程id")
    private Integer cid;


}
