package com.example.samplerestsv.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.samplerestsv.model.User;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM t_user WHERE id = #{id}")
	User get(int id);
}
