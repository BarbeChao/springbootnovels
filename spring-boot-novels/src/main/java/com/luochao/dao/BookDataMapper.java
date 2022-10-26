package com.luochao.dao;

import com.luochao.domain.BookData;
import com.luochao.vo.BookDirectoryVo;

import java.util.List;

public interface BookDataMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BookData record);

    BookData selectByPrimaryKey(Long id);

    List<BookData> selectAll();

    int updateByPrimaryKey(BookData record);

    BookData selectBydirectoryId(String directoryId);

    List<BookDirectoryVo> selectAlldirectory(String bookId);
}