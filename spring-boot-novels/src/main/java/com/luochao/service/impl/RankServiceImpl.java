package com.luochao.service.impl;

import com.luochao.bean.BookRank;
import com.luochao.commons.Commons;
import com.luochao.dao.BookMapper;
import com.luochao.service.RankService;
import com.luochao.util.RankUtil;
import com.luochao.util.RedisUtil;
import com.luochao.vo.BookDetailVo;
import com.luochao.vo.RankVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class RankServiceImpl implements RankService {
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private RankUtil rankUtil;
    @Autowired
    private BookMapper mapper;
    @Override
    public List<RankVo> shelfRank() {
        BookRank bookRank=null;
        List<BookRank> list = new ArrayList<>();
        List<RankVo> rankVos = new ArrayList<>();
        Set<String> set = redisUtil.keys("*"+Commons.FEV_NUM);
        for (String s : set) {

            int num =(int) redisUtil.get(s);
            bookRank = new BookRank(s,num);
            list.add(bookRank);
        }
        List<BookRank> lists = rankUtil.sort(list);
        for (BookRank rank : lists) {
            String bookId = rank.getId().substring(0,7);
            BookDetailVo book= mapper.selectById(bookId);
            RankVo rv = new RankVo();
            BeanUtils.copyProperties(book,rv);
            rankVos.add(rv);
        }
        return rankVos;
    }

    @Override
    public List<RankVo> redRank() {
        BookRank bookRank =null;
        List<BookRank> bookRanks = new ArrayList<>();
        List<RankVo> rankVos = new ArrayList<>();
        Set<String> set = redisUtil.keys("*"+Commons.RED_NUM);
        for (String s : set) {
            int num = (int) redisUtil.get(s);
             bookRank = new BookRank(s,num);
             bookRanks.add(bookRank);
        }
        List<BookRank> lists = rankUtil.sort(bookRanks);
        for (BookRank list : lists) {
            String bookId = list.getId().substring(0,7);
            BookDetailVo bookDetailVo = mapper.selectById(bookId);
            RankVo rv =new RankVo();
            BeanUtils.copyProperties(bookDetailVo,rv);
            rankVos.add(rv);
        }
        return rankVos;
    }


}
