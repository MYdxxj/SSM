package com.web.dao;

import com.web.model.ProductPriceList;
import com.web.model.ProductPriceListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductPriceListMapper {
    int countByExample(ProductPriceListExample example);

    int deleteByExample(ProductPriceListExample example);

    int deleteByPrimaryKey(Integer priceListId);

    int insert(ProductPriceList record);

    int insertSelective(ProductPriceList record);

    List<ProductPriceList> selectByExample(ProductPriceListExample example);

    ProductPriceList selectByPrimaryKey(Integer priceListId);

    int updateByExampleSelective(@Param("record") ProductPriceList record, @Param("example") ProductPriceListExample example);

    int updateByExample(@Param("record") ProductPriceList record, @Param("example") ProductPriceListExample example);

    int updateByPrimaryKeySelective(ProductPriceList record);

    int updateByPrimaryKey(ProductPriceList record);

    List<ProductPriceList> selectPriceByPage(@Param(value = "startPos") Integer startPos,
                                              @Param(value = "pageSize") Integer pageSize);
    long getPriceCount();

    List<ProductPriceList> likeQuery(String productPriceName);

    ProductPriceList selectByName(String priceListName);
}