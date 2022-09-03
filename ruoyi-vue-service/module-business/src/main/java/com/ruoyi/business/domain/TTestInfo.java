package com.ruoyi.business.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.extend.dbcolumn.annotation.EncryptField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 测试对象 t_test_info
 *
 * @author Tellsea
 * @date 2022-09-02
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class TTestInfo extends BaseEntity {

    /**
     * ID
     */
    private Long id;

    /**
     * 门店名称
     */
    @Excel(name = "门店名称")
    @EncryptField
    private String storeName;

    /**
     * 门店图片
     */
    @Excel(name = "门店图片")
    private String picture;

}
