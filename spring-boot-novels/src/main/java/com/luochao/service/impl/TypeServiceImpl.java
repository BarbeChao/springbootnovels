package com.luochao.service.impl;

import com.luochao.dao.TypeMapper;
import com.luochao.domain.Book;
import com.luochao.domain.Type;
import com.luochao.service.TypeService;
import com.luochao.vo.RankVo;
import com.luochao.vo.TypeVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<TypeVo> selectType() {
        List<TypeVo> voList = new ArrayList<>();
        List<Type> typeList = typeMapper.selectAll();
        for (Type type : typeList) {
            TypeVo typeVo = new TypeVo();
            BeanUtils.copyProperties(type,typeVo);
            voList.add(typeVo);
        }
        return voList;
    }

    @Override
    public List<RankVo> selectTypeBook(String typeId) {
        List<Book> books = typeMapper.selectByTypeId(typeId);
        List<RankVo> rankVoList  = new ArrayList<>();
        for (Book book : books) {
            RankVo rv = new RankVo();
            BeanUtils.copyProperties(book,rv);
            rankVoList.add(rv);
        }
        return rankVoList;
    }
}
