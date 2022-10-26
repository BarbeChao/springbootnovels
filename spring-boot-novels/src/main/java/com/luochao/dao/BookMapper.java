package com.luochao.dao;

import com.luochao.domain.Book;
import com.luochao.vo.BookDetailVo;

import java.util.List;

public interface BookMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Book record);

    Book selectByPrimaryKey(Long id);

    List<Book> selectAll();

    int updateByPrimaryKey(Book record);

    List<Book> selectByName(String name);

    BookDetailVo selectById(String bookId);
}