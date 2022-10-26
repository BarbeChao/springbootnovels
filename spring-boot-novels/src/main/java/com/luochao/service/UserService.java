package com.luochao.service;

import com.luochao.domain.User;

public interface UserService {
    User selectByUserId(User user);

    String insert(User user);

    void updataName(User user,String name);

    void updataSex(User user,String sex);

    void updataAge(User user,String age);

    String updataPassword(User user,String oldpassword,String newpassword);
}
