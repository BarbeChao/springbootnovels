package com.luochao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Book {
    private Long id;

    private String bookId;

    private String bookName;

    private String typeId;

    private String authorId;

    private String authorName;

    private String bookImg;

    private String bookDesc;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", typeId='" + typeId + '\'' +
                ", authorId='" + authorId + '\'' +
                ", authorName='" + authorName + '\'' +
                ", bookImg='" + bookImg + '\'' +
                ", bookDesc='" + bookDesc + '\'' +
                '}';
    }
}