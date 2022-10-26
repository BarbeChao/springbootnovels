package com.luochao.controller;

import com.google.gson.Gson;
import com.luochao.service.BookDataService;
import com.luochao.vo.BookDataVo;
import com.luochao.vo.BookDirectoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookDataController {
    @Autowired
    private BookDataService bookDataService;

//    获取目录
    @RequestMapping("/directory/{bookId}")
    @ResponseBody
    public String selectAlldirectory(@PathVariable("bookId") String bookId){
        Gson gson =new Gson();
        List<BookDirectoryVo> bookList = bookDataService.selectAlldirectory(bookId);
        String dirjson = gson.toJson(bookList);
        return dirjson;
    }

    //获取指定的章节文章
    @RequestMapping("/reader/{directoryId}")
    public String selectBydirectoryId(@PathVariable("directoryId") String directoryId, Model model){
        BookDataVo bookDataVo = bookDataService.selectBydirectoryId(directoryId);
        model.addAttribute("bookDataVo",bookDataVo);
        return "bookreader";
    }


    //爬取数据接口
    @RequestMapping("/insert/{bookUrl}")
    @ResponseBody
    public String insert(@PathVariable("bookUrl") String bookUrl,String bookId){
        bookDataService.insertData(bookId,bookUrl);
        return "seccess";
    }


}
