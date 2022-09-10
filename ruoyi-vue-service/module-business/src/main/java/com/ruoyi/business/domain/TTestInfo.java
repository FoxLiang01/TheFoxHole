package com.ruoyi.business.domain;

import cn.zhz.privacy.annotation.FieldEncrypt;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.extend.datasecurity.privacy.config.PrivacyCryptoConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 测试对象 t_test_info
 *
 * @author Tellsea
 * @date 2022-09-02
 */
@Data
@Accessors(chain = true)
@ToString(callSuper = true)
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
    @FieldEncrypt(iCrypto = PrivacyCryptoConfig.class)
    private String storeName;

    /**
     * 门店图片
     */
    @Excel(name = "门店图片")
    private String picture;

}
