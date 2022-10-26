package com.luochao.controller;

import com.luochao.service.RankService;
import com.luochao.vo.RankVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class RankController {

    @Autowired
    private RankService rankService;

    @RequestMapping("/redis/rank/Shelfnum")
    public ArrayList<RankVo> ShelRank(){
        return (ArrayList<RankVo>) rankService.shelfRank();
    }

    @RequestMapping("/redis/rank/Red")
    public ArrayList<RankVo> red(){
        return (ArrayList<RankVo>) rankService.redRank();
    }
}
