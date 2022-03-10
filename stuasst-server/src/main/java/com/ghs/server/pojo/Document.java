package com.ghs.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2022-03-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("s_document")
@ApiModel(value="Document对象", description="")
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "文件名")
    private String name;

    @ApiModelProperty(value = "文件类型")
    private String type;

    @ApiModelProperty(value = "文件路径")
    private String path;

    @ApiModelProperty(value = "文件大小")
    private String size;

    @ApiModelProperty(value = "上传时间")
    private String time;

    @ApiModelProperty(value = "返回结果，供存储过程使用")
    @TableField(exist = false)
    private Integer result;

    @ApiModelProperty(value = "返回插入id，供存储过程使用")
    @TableField(exist = false)
    private Integer reId;
}
