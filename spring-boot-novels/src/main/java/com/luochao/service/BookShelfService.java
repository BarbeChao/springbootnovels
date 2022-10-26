package com.luochao.service;

import com.luochao.vo.BookVo;

import java.util.List;

public interface BookShelfService {
    //查找指定书本和指定用户的一条关系
    boolean collect(String uesrId,String bookId);

    //用户新收藏一本书
    Integer insert(String userId,String bookId);

    //用户取消收藏一本书
    Integer delete(String userId,String bookId);

    //用户查询自己所有收藏的书籍
    List<BookVo> select(String userId);
}
