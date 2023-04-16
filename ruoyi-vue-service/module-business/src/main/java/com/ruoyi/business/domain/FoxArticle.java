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
 * 文章对象 fox_article
 *
 * @author Foxx
 * @date 2023-03-25
 */
//@Data
//@Accessors(chain = true)
//@ToString(callSuper = true)
//@EqualsAndHashCode(callSuper = true)
public class FoxArticle extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 删除标志（0存在 2删除） */
    private String delFlag;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 概述 */
    @Excel(name = "概述")
    private String summary;

    /** 笔记 */
    @Excel(name = "笔记")
    private String note;

    /** 文章内容 */
    @Excel(name = "文章内容")
    private String content;

    /** 阅读量 */
    @Excel(name = "阅读量")
    private Long click;

    /** 点赞数 */
    @Excel(name = "点赞数")
    private Long kudos;

    /** 文章状态（0发布 1草稿） */
    @Excel(name = "文章状态", readConverterExp = "0=发布,1=草稿")
    private String status;

    /** 是否能被评论（0否 1是） */
    @Excel(name = "是否能被评论", readConverterExp = "0=否,1=是")
    private String isComment;

    /** 是否置顶（0否 1是） */
    @Excel(name = "是否置顶", readConverterExp = "0=否,1=是")
    private String isTop;

    /** 顶部图 */
    @Excel(name = "顶部图")
    private String banner;

    /** 分类的id */
    @Excel(name = "分类的id")
    private Long categoryId;

    private String categoryPath;

    /** 章节（默认-1 自动填充） */
    @Excel(name = "章节", readConverterExp = "默=认-1,自=动填充")
    private int chapter;

    private String notePosition;

    /** 限制级（0清水 1R18） */
    private String rating;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setSummary(String summary)
    {
        this.summary = summary;
    }

    public String getSummary()
    {
        return summary;
    }
    public void setNote(String note)
    {
        this.note = note;
    }

    public String getNote()
    {
        return note;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setClick(Long click)
    {
        this.click = click;
    }

    public Long getClick()
    {
        return click;
    }
    public void setKudos(Long kudos)
    {
        this.kudos = kudos;
    }

    public Long getKudos()
    {
        return kudos;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setIsComment(String isComment)
    {
        this.isComment = isComment;
    }

    public String getIsComment()
    {
        return isComment;
    }
    public void setIsTop(String isTop)
    {
        this.isTop = isTop;
    }

    public String getIsTop()
    {
        return isTop;
    }
    public void setBanner(String banner)
    {
        this.banner = banner;
    }

    public String getBanner()
    {
        return banner;
    }
    public void setCategoryId(Long categoryId)
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId()
    {
        return categoryId;
    }
    public void setCategoryPath(String categoryPath)
    {
        this.categoryPath = categoryPath;
    }

    public String getCategoryPath()
    {
        return categoryPath;
    }
    public void setChapter(int chapter)
    {
        this.chapter = chapter;
    }

    public int getChapter()
    {
        return chapter;
    }

    public void setNotePosition(String notePosition)
    {
        this.notePosition = notePosition;
    }

    public String getNotePosition()
    {
        return notePosition;
    }

    public void setRating(String rating)
    {
        this.rating = rating;
    }

    public String getRating()
    {
        return rating;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("delFlag", getDelFlag())
                .append("title", getTitle())
                .append("summary", getSummary())
                .append("note", getNote())
                .append("content", getContent())
                .append("click", getClick())
                .append("kudos", getKudos())
                .append("status", getStatus())
                .append("isComment", getIsComment())
                .append("isTop", getIsTop())
                .append("banner", getBanner())
                .append("categoryId", getCategoryId())
                .append("chapter", getChapter())
                .append("rating", getRating())
                .toString();
    }

}
