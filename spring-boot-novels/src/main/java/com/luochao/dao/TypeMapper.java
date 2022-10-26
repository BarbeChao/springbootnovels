package com.luochao.dao;

import com.luochao.domain.Book;
import com.luochao.domain.Type;

import java.util.List;

public interface TypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Type record);

    Type selectByPrimaryKey(Long id);

    List<Type> selectAll();

    int updateByPrimaryKey(Type record);

    List<Book> selectByTypeId(String typeId);
}