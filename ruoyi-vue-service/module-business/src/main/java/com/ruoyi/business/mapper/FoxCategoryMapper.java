package com.ruoyi.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.business.domain.FoxCategory;
import com.ruoyi.business.vo.FoxCategoryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 合集Mapper接口
 *
 * @author Foxx
 * @date 2023-03-25
 */
@Mapper
public interface FoxCategoryMapper extends BaseMapper<FoxCategory> {

    /**
     * 查询合集
     *
     * @param id 合集主键
     * @return 合集
     */
    public FoxCategory selectFoxCategoryById(Long id);

    /**
     * 查询合集列表
     *
     * @return 合集集合
     */
    public List<Map<String, Object>> selectFoxCategoryList(@Param("params") Map<String, Object> params);

    public List<FoxCategory> selectFoxCategoryChildList();

}
