package com.ruoyi.test.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 门店对象 t_store_info
 *
 * @author Tellsea
 * @date 2022-09-01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TStoreInfo extends BaseEntity {

    /**
     * ID
     */
    private Long id;

    /**
     * 门店名称
     */
    @Excel(name = "门店名称")
    private String storeName;

    /**
     * 门店图片
     */
    @Excel(name = "门店图片")
    private String picture;

}
