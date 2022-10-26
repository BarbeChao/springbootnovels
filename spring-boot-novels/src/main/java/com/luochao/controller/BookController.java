package com.luochao.controller;

import com.luochao.service.BookService;
import com.luochao.vo.BookDetailVo;
import com.luochao.vo.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

//    主页
    @GetMapping("/index")
    public String index(){
        return "index";
    }

//    查找一本书
    @GetMapping("/book/search")
    public String bookList(@RequestParam("keyword") String keyword, Model model){
        System.out.println(keyword);
        List<BookVo> bookVos =bookService.selectByName(keyword);
        model.addAttribute("bookVos",bookVos);
        System.out.println(bookVos);

        //TODO 记录作品被搜索的次数
        //TODO 页面展示
        return "booklist";
    }

//书籍详情
//  /book/detail/bookId=1111
//  通过bookId 从book表，及type和author表中联合查询 返回具体详情信息
    @GetMapping("/book/detail")
    public String bookDetail(@RequestParam("bookId") String bookId,String on,Model model){
        BookDetailVo bookDetailVo = bookService.selectById(bookId,on);
        model.addAttribute("bookdetailvo",bookDetailVo);
        return "bookdetail";
    }

//跳转搜索
    @GetMapping("/book/sousuo")
    public String bookSousuo(){
        return "sousuo";
    }

}
