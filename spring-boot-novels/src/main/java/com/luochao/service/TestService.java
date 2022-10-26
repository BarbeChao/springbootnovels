package com.luochao.service;

import com.luochao.domain.Book;
import com.luochao.domain.UserRole;

import java.util.List;

public interface TestService {
    String test();

    List<UserRole> getUser();

    List<Book> getBook();
}
