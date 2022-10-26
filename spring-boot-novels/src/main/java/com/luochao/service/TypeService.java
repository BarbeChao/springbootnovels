package com.luochao.service;

import com.luochao.vo.RankVo;
import com.luochao.vo.TypeVo;

import java.util.List;

public interface TypeService {
    List<TypeVo> selectType();

    List<RankVo> selectTypeBook(String typeId);
}
