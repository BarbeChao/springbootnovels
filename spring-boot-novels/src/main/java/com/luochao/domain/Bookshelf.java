package com.luochao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Bookshelf {
    private Long id;

    private String userId;

    private String bookId;


    @Override
    public String toString() {
        return "Bookshelf{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", bookId='" + bookId + '\'' +
                '}';
    }
}