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
 * 文件对象 fox_file
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Data
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class FoxFile extends BaseEntity {

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String remark;

    /**
     * 附件
     */
    @Excel(name = "附件")
    private String file;

}
