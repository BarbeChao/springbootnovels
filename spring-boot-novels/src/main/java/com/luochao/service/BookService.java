package com.luochao.service;

import com.luochao.vo.BookDetailVo;
import com.luochao.vo.BookVo;

import java.util.List;

public interface BookService {
    //vo对象根据数据库domain对象生成
    List<BookVo> selectByName(String name);

    BookDetailVo selectById(String bookId, String on);
}
