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
 * @since 2022-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("s_tally")
@ApiModel(value="Tally对象", description="")
public class Tally implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "账单日期")
    private String date;

    @ApiModelProperty(value = "消费类型")
    private String type;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "金额")
    private Float money;

    @ApiModelProperty(value = "是否为收入")
    private Boolean isIncome;

    @ApiModelProperty(value = "返回结果，供存储过程使用")
    @TableField(exist = false)
    private Integer result;

    @ApiModelProperty(value = "返回插入id，供存储过程使用")
    @TableField(exist = false)
    private Integer reId;

    @ApiModelProperty(value = "返回插入id，供存储过程使用")
    @TableField(exist = false)
    private String time;
}
