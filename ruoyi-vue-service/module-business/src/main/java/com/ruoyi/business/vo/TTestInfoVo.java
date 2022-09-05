package com.ruoyi.business.vo;

import com.ruoyi.business.domain.TTestInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 测试Vo对象 t_test_info
 *
 * @author Tellsea
 * @date 2022-09-02
 */
@Data
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TTestInfoVo extends TTestInfo {

}
