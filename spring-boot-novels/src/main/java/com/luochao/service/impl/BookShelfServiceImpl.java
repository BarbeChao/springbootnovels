package com.luochao.service.impl;

import com.luochao.commons.Commons;
import com.luochao.dao.BookshelfMapper;
import com.luochao.domain.Book;
import com.luochao.domain.Bookshelf;
import com.luochao.service.BookShelfService;
import com.luochao.util.RedisUtil;
import com.luochao.vo.BookVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookShelfServiceImpl implements BookShelfService {
    @Autowired
    private BookshelfMapper bookshelfMapper;

    @Autowired
    private RedisUtil redisUtil;

    //查询是否收藏这本书
    @Override
    public boolean collect(String uesrId, String bookId) {
        Bookshelf bookshelf = bookshelfMapper.selectByUserAndBook(uesrId,bookId);
        return bookshelf !=null;
    }

    //新增收藏一本书
    @Override
    public Integer insert(String userId,String bookId) {
         if(collect(userId,bookId)){
             return -1;
         }
        Bookshelf bookshelf = new Bookshelf(null,userId,bookId);
        Integer result = bookshelfMapper.insert(bookshelf);

        //通过redis记录新增的次数
        String numKey = bookId+Commons.FEV_NUM;
        if(!redisUtil.hasKey(numKey)){
            redisUtil.set(numKey,1);
        }else {
            redisUtil.incre(numKey);
        }

        return result;
    }

    //取消收藏一本书
    @Override
    public Integer delete(String userId, String bookId) {
        Integer result =  bookshelfMapper.deleteByUserAndBook(userId, bookId);

        //通过redis记录取消收藏的次数
        String numKey = bookId+ Commons.FEV_NUM;
        redisUtil.decre(numKey);
        if (result==1) return result;
        return -1;
    }

    //查询一个用户所有的书籍
    @Override
    public List<BookVo> select(String userId) {
        List<Book> bookshelfList = bookshelfMapper.selectAllByUser(userId);
        List<BookVo> bookVos = new ArrayList<>();
        for (Book book : bookshelfList) {
            BookVo bookVo = new BookVo();
            BeanUtils.copyProperties(book,bookVo);;
            bookVos.add(bookVo);
        }
        return bookVos;
    }



}
