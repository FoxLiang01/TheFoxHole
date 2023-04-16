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
 * 标签对象 fox_tag
 *
 * @author Foxx
 * @date 2023-03-25
 */
//@Data
//@Accessors(chain = true)
//@ToString(callSuper = true)
//@EqualsAndHashCode(callSuper = true)
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

    private String path;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setTagName(String tagName)
    {
        this.tagName = tagName;
    }

    public String getTagName()
    {
        return tagName;
    }
    public void setMetaTag(Long metaTag)
    {
        this.metaTag = metaTag;
    }

    public Long getMetaTag()
    {
        return metaTag;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public String getPath()
    {
        return path;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("tagName", getTagName())
                .append("metaTag", getMetaTag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("status", getStatus())
                .append("delFlag", getDelFlag())
                .append("path", getPath())
                .toString();
    }
}
