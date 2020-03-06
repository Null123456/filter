package com.example.filter.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Showip {

    @Select("select ip from ip_white_list where ip = #{ip}")
    public String selectIp(String ip);

}
