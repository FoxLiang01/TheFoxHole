package com.ruoyi.business.domain;

import com.ruoyi.common.annotation.Excel;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 订阅对象 fox_subscribe
 *
 * @author Foxx
 * @date 2023-03-25
 */
//@Data
//@Accessors(chain = true)
//@ToString(callSuper = true)
//@EqualsAndHashCode(callSuper = true)
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
     * 删除标志（0存在 2删除）
     */
    private String delFlag;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setSubscriber(String subscriber)
    {
        this.subscriber = subscriber;
    }

    public String getSubscriber()
    {
        return subscriber;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("subscriber", getSubscriber())
                .append("email", getEmail())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("delFlag", getDelFlag())
                .toString();
    }
}
