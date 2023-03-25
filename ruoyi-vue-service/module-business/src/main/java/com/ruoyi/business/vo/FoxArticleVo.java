package com.ruoyi.business.vo;

import com.ruoyi.business.domain.FoxArticle;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 文章Vo对象 fox_article
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Data
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class FoxArticleVo extends FoxArticle {

}
