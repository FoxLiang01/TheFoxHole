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
 * 合集对象 fox_category
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Data
@Accessors(chain = true)
//@ToString(callSuper = true)
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

    private String delFlag;

    /**
     * 文章列表（0不是 1是）
     */
    private String articleList;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setMetaCategory(Long metaCategory)
    {
        this.metaCategory = metaCategory;
    }

    public Long getMetaCategory()
    {
        return metaCategory;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    public void setArticleList(String articleList)
    {
        this.articleList = articleList;
    }

    public String getArticleList()
    {
        return articleList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("status", getStatus())
                .append("metaCategory", getMetaCategory())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
