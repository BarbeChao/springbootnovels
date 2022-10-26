package com.luochao.controller;

import com.luochao.service.BookDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

    @Autowired
    private BookDataService testService;

//    @RequestMapping("/test")
//    @ResponseBody
//    public String test(){
//
//        testService.insertData(SpiderUtil.aa("0000002"));
//        return "testController";
//    }

//    @RequestMapping("/testService")
//    @ResponseBody
//    public String testService(){
//        return testService.test();
//    }
//
//    @RequestMapping("/testThymeleaf")
//    public String testThymeleaf(){
//        return "testThymeleaf";
//    }
//
//    @RequestMapping("/testsql")
//    @ResponseBody
//    public List<UserRole> getUser(){
//       return testService.getUser();
//    }
//
//    @RequestMapping("/getBook")
//    @ResponseBody
//    public String getBook(){
//        Gson gson = new Gson();
//        String book = gson.toJson(testService.getBook());
//         return book;
//    }
}
