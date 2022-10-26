package com.luochao.service.impl;

import com.luochao.dao.BookMapper;
import com.luochao.dao.UserMapper;
import com.luochao.domain.Book;
import com.luochao.domain.UserRole;
import com.luochao.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BookMapper bookMapper;
    public String test(){
        return "test ok";
    }

    @Override
    public List<UserRole> getUser() {
        return null;
    }

    @Override
    public List<Book> getBook() {
        return bookMapper.selectAll();
    }
}
