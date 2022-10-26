package com.luochao.dao;

import com.luochao.domain.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    User selectByUserId(String UserId);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}