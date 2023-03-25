package com.ruoyi.business.vo;

import com.ruoyi.business.domain.FoxArticleTag;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 文章与标题的关联Vo对象 fox_article_tag
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Data
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class FoxArticleTagVo extends FoxArticleTag {

}
