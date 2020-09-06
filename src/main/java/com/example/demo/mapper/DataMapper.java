package com.example.demo.mapper;

import com.example.demo.model.Data;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DataMapper {
    @Insert("insert into data (dataname,define,content) values(#{dataname},#{define},#{content})")
    void adddata(Data data);

    @Select("select * from data where dataname=#{dataname}")
    Data getdata(String dataname);

    @Update("update data set define=#{define},content=#{content} where dataname=#{dataname}")
    void updatedata(String dataname,String define,String content);

    @Delete("delete from data where dataname=#{dataname}")
    void deletedata(String dataname);

    @Select("select * from data")
    List<Data> getallusers();

}
