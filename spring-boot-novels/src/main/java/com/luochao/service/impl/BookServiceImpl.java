package com.luochao.service.impl;

import com.luochao.commons.Commons;
import com.luochao.dao.BookMapper;
import com.luochao.domain.Book;
import com.luochao.service.BookService;
import com.luochao.util.RedisUtil;
import com.luochao.vo.BookDetailVo;
import com.luochao.vo.BookVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private RedisUtil redisUtil;
    @Override
    public List<BookVo> selectByName(String name) {
        List<Book> BookList = bookMapper.selectByName(name);
        List<BookVo> bookVos = new ArrayList<>();
        for(int i =0 ;i<BookList.size();i++){
            BookVo vo = new BookVo();
            BeanUtils.copyProperties(BookList.get(i),vo);
            bookVos.add(vo);
        }
        return bookVos;
    }

    @Override
    public BookDetailVo selectById(String bookId,String on) {
        BookDetailVo bookDetailVo = bookMapper.selectById(bookId);
        if(on.equals("1")){
            System.out.println("进入");
            String keyName = bookId+ Commons.RED_NUM;
            if(!redisUtil.hasKey(keyName)){
                redisUtil.set(keyName,1);
            }else {
                redisUtil.incre(keyName);
            }
        }

        return bookDetailVo;
    }


}
