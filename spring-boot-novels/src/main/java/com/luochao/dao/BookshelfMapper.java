package com.luochao.dao;

import com.luochao.domain.Book;
import com.luochao.domain.Bookshelf;

import java.util.List;

public interface BookshelfMapper {
    int deleteByPrimaryKey(Long id);

    //根据一个用户ID和书本ID取消收藏关系
    int deleteByUserAndBook(String userId,String bookId);

    //收藏一本书籍
    int insert(Bookshelf record);

    Bookshelf selectByPrimaryKey(Long id);

    //查询一条 用户和书本是否存在收藏关系
    Bookshelf selectByUserAndBook(String userId, String bookId);

    List<Bookshelf> selectAll();

    //根据一个用户ID查找所有的书籍
    List<Book> selectAllByUser(String userId);

    int updateByPrimaryKey(Bookshelf record);
}