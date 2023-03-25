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
 * 评论对象 fox_comment
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Data
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class FoxComment extends BaseEntity {

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 邮箱
     */
    @Excel(name = "邮箱")
    private String email;

    /**
     * 内容
     */
    @Excel(name = "内容")
    private String content;

    /**
     * 父级评论的id
     */
    @Excel(name = "父级评论的id")
    private Long metaComment;

    /**
     * 删除标志（0存在 2删除）
     */
    private String delFlag;

}
