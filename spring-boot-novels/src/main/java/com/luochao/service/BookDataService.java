package com.luochao.service;

import com.luochao.vo.BookDataVo;
import com.luochao.vo.BookDirectoryVo;

import java.util.List;

public interface BookDataService {
    void insertData(String bookId,String bookUrl);

    List<BookDirectoryVo> selectAlldirectory(String bookId);

    BookDataVo selectBydirectoryId(String directoryId);
}
