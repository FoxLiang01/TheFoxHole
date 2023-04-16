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
 * 评论对象 fox_comment
 *
 * @author Foxx
 * @date 2023-03-25
 */
//@Data
//@Accessors(chain = true)
//@ToString(callSuper = true)
//@EqualsAndHashCode(callSuper = true)
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

    private String name;

    private Long articleId;

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
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setMetaComment(Long metaComment)
    {
        this.metaComment = metaComment;
    }

    public Long getMetaComment()
    {
        return metaComment;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setArticleId(Long articleId)
    {
        this.articleId = articleId;
    }

    public Long getArticleId()
    {
        return articleId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("email", getEmail())
                .append("content", getContent())
                .append("metaComment", getMetaComment())
                .append("delFlag", getDelFlag())
                .toString();
    }

}
