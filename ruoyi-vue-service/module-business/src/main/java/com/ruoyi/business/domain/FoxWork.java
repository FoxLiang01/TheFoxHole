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
 * 连载文章对象 fox_work
 *
 * @author Foxx
 * @date 2023-03-25
 */
//@Data
//@Accessors(chain = true)
//@ToString(callSuper = true)
//@EqualsAndHashCode(callSuper = true)
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

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setWorkTitle(String workTitle)
    {
        this.workTitle = workTitle;
    }

    public String getWorkTitle()
    {
        return workTitle;
    }
    public void setCategoryId(Long categoryId)
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId()
    {
        return categoryId;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getRemark()
    {
        return remark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("workTitle", getWorkTitle())
                .append("remark", getRemark())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("categoryId", getCategoryId())
                .toString();
    }
}
