package com.luochao.dao;

import com.luochao.domain.Author;

import java.util.List;

public interface AuthorMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Author record);

    Author selectByPrimaryKey(Long id);

    List<Author> selectAll();

    int updateByPrimaryKey(Author record);
}