package com.luochao.controller;

import com.luochao.service.BookShelfService;
import com.luochao.vo.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookShelfController {

    @Autowired
    private BookShelfService bookShelfService;

    //查询用户和书籍的收藏关系
    @GetMapping("/book/isCollect")
    @ResponseBody
    public boolean collect(String userId,String bookId){
       Boolean iscollect = bookShelfService.collect(userId,bookId);
       System.out.println(iscollect);
       return iscollect;
    }
    //用户收藏一本书（新增）
    @GetMapping("/book/insert")
    @ResponseBody
    public Integer insert(String userId,String bookId){
        Integer result = bookShelfService.insert(userId,bookId);
        return result;
    }
    //用户取消收藏某一本书
    @GetMapping("/book/delete")
    @ResponseBody
    public Integer delete(String userId,String bookId){
        Integer result = bookShelfService.delete(userId, bookId);
        return result;
    }
    //查询某用户所有收藏的书籍（查询全部）
    @GetMapping("/book/select/{userId}")
    @ResponseBody
    public List<BookVo> select(@PathVariable("userId") String userId){
        List<BookVo> BookVos = bookShelfService.select(userId);
        return BookVos;
    }

}
