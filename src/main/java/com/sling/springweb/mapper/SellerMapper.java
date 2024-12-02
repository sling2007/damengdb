package com.sling.springweb.mapper;


import com.sling.springweb.entity.Seller;
import com.sling.springweb.entity.YourTable;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * User: sunling
 * Date: 2024/11/29 13:35
 * Description:
 **/
@Mapper
public interface SellerMapper {
    @Select("SELECT * FROM HMNTECH.seller WHERE id = #{id}")
    Seller getSellerById(Long id);

    @Select("SELECT * FROM HMNTECH.seller")
    List<Seller> getAllSellers();

    @Select("SELECT * FROM HMNTECH.your_table WHERE column2 = #{id}")
    List<YourTable> getYourTableById(Long id);

//    @Insert("INSERT INTO HMNTECH.SELLER(id, name) VALUES(HMNTECH.seller_sequence.NEXTVAL, #{name})")
    @SelectKey(statement = "SELECT HMNTECH.seller_sequence.NEXTVAL", keyProperty = "id", before = true, resultType = Long.class)
    @Insert("INSERT INTO HMNTECH.SELLER(id, name) VALUES(#{id}, #{name})")
    void insertSeller(Seller user);

    @Update("UPDATE Seller SET name=#{name} WHERE id=#{id}")
    void updateSeller(Seller user);

    @Delete("DELETE FROM Seller WHERE id=#{id}")
    void deleteSeller(Long id);
}
