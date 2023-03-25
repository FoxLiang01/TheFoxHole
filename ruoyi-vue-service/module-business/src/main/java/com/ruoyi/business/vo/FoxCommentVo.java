package com.ruoyi.business.vo;

import com.ruoyi.business.domain.FoxComment;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 评论Vo对象 fox_comment
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Data
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class FoxCommentVo extends FoxComment {

}
