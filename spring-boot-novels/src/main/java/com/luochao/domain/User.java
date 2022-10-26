package com.luochao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class User {
    private Long id;

    private String userId;

    private String userPassword;

    private String name;

    private String age;

    private String sex;

    private Integer money;




}