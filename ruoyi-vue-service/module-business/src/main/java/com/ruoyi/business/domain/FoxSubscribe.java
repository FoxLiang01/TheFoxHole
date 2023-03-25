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
 * 订阅对象 fox_subscribe
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Data
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class FoxSubscribe extends BaseEntity {

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 订阅人名称
     */
    @Excel(name = "订阅人名称")
    private String subscriber;

    /**
     * 邮箱
     */
    @Excel(name = "邮箱")
    private String email;

    /**
     * 订阅文章的id
     */
    @Excel(name = "订阅文章的id")
    private Long workId;

    /**
     * 删除标志（0存在 2删除）
     */
    private String delFlag;

}
