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
 * 标签对象 fox_tag
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Data
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class FoxTag extends BaseEntity {

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 标签名称
     */
    @Excel(name = "标签名称")
    private String tagName;

    /**
     * 父级标签
     */
    @Excel(name = "父级标签")
    private Long metaTag;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String remark;

    /**
     * 状态（0存在 1禁用）
     */
    @Excel(name = "状态", readConverterExp = "0=存在,1=禁用")
    private String status;

    /**
     * 删除标志（0存在 2删除）
     */
    private String delFlag;

}
