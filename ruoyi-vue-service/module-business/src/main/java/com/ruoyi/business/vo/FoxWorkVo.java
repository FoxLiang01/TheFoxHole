package com.ruoyi.business.vo;

import com.ruoyi.business.domain.FoxWork;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 连载文章Vo对象 fox_work
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Data
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class FoxWorkVo extends FoxWork {

}
