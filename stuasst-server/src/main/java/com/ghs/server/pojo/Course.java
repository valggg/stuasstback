package com.ghs.server.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ghs
 * @since 2022-02-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("s_course")
@ApiModel(value="Course对象", description="")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "课程名称")
    private String name;

    @ApiModelProperty(value = "授课教师")
    private String teacher;

    @ApiModelProperty(value = "教室")
    private String address;

    @ApiModelProperty(value = "课程周数")
    private String weeks;

    @ApiModelProperty(value = "坐标")
    private String coord;

    @ApiModelProperty(value = "颜色")
    private String color;

    @ApiModelProperty(value = "返回结果，供存储过程使用")
    @TableField(exist = false)
    private Integer result;

}
