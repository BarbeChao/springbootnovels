package com.luochao.service.impl;

import com.luochao.dao.UserMapper;
import com.luochao.domain.User;
import com.luochao.service.UserService;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper mapper;
    @Override
    public User selectByUserId(User user) {
        //获取加密器
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        //设置加密语
        encryptor.setPassword("luochaoyyds");
        User newUser  = mapper.selectByUserId(encryptor.decrypt(encryptor.decrypt(user.getUserId())));
        if(newUser !=null&& newUser.getUserId().equals(encryptor.decrypt(encryptor.decrypt(user.getUserId())))){
            if(newUser.getUserPassword().equals(encryptor.decrypt(encryptor.decrypt(user.getUserPassword())))){
                return newUser;
            }
        }
        return null;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public String insert(User user) {
        if(user.getMoney()==null){
            user.setMoney(0);
        }
        int results = mapper.insert(user);
        if(results == 1){
            return "注册成功";
        }
        return "注册失败";
    }

    @Override
    public void updataName(User user, String name) {
        user.setName(name);
        mapper.updateByPrimaryKey(user);
    }

    @Override
    public void updataSex(User user, String sex) {
        user.setSex(sex);
        mapper.updateByPrimaryKey(user);
    }

    @Override
    public void updataAge(User user, String age) {
        user.setAge(age);
        mapper.updateByPrimaryKey(user);
    }

    @Override
    public String updataPassword(User user, String oldpassword, String newpassword) {
        System.out.println("=="+user.getUserPassword());
        System.out.println("=="+oldpassword);
        if(user.getUserPassword().equals(oldpassword)){
            user.setUserPassword(newpassword);
            mapper.updateByPrimaryKey(user);
            return "修改成功";
        }
        return "密码错误";
    }
}
