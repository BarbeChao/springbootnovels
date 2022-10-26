package com.luochao.service;

import com.luochao.vo.RankVo;

import java.util.List;

public interface RankService {
    List<RankVo> shelfRank();

    List<RankVo> redRank();
}
