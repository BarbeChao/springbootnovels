package com.luochao.controller;

import com.luochao.service.TypeService;
import com.luochao.vo.RankVo;
import com.luochao.vo.TypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping("/type/name")
    @ResponseBody
    public List<TypeVo> selectType(){
        List<TypeVo> voList = typeService.selectType();
        return voList;
    }

    @RequestMapping("/typelist")
    public String typeList(String typeId, Model model){
        model.addAttribute("typeId",typeId);
        return "typelist";
    }

    @RequestMapping("/type/book")
    @ResponseBody
    public List<RankVo> selectTypeBook(String typeId){
        return typeService.selectTypeBook(typeId);
    }
}
