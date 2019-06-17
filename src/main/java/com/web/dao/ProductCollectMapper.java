package com.web.dao;

import com.web.model.ProductCollect;
import com.web.model.ProductCollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductCollectMapper {
    int countByExample(ProductCollectExample example);

    int deleteByExample(ProductCollectExample example);

    int deleteByPrimaryKey(Integer productMsgId);

    int insert(ProductCollect record);

    int insertSelective(ProductCollect record);

    List<ProductCollect> selectByExample(ProductCollectExample example);

    ProductCollect selectByPrimaryKey(Integer productMsgId);

    int updateByExampleSelective(@Param("record") ProductCollect record, @Param("example") ProductCollectExample example);

    int updateByExample(@Param("record") ProductCollect record, @Param("example") ProductCollectExample example);

    int updateByPrimaryKeySelective(ProductCollect record);

    int updateByPrimaryKey(ProductCollect record);

    public List<ProductCollect> selectProductCollectByPage(@Param(value="startPos") Integer startPos,
                                                           @Param(value="pageSize") Integer pageSize);
    public long getProductCollectCount();

    int deleteByProductId(Integer productId);
}