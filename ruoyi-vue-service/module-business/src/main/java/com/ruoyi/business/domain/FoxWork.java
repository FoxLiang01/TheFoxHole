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
 * 连载文章对象 fox_work
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Data
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class FoxWork extends BaseEntity {

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 连载文章名称
     */
    @Excel(name = "连载文章名称")
    private String workTitle;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String remark;

    /**
     * 合集id（默认-1）
     */
    @Excel(name = "合集id", readConverterExp = "默=认-1")
    private Long categoryId;

}
