package com.ruoyi.business.domain;

import com.ruoyi.common.annotation.Excel;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 合集对象 fox_category
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Data
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class FoxCategory extends BaseEntity {

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 合集名称
     */
    @Excel(name = "合集名称")
    private String name;

    /**
     * 状态（0存在 1禁用）
     */
    @Excel(name = "状态", readConverterExp = "0=存在,1=禁用")
    private String status;

    /**
     * 父级合集
     */
    @Excel(name = "父级合集")
    private Long metaCategory;

    /**
     * 备注或描述
     */
    @Excel(name = "备注或描述")
    private String remark;

}
