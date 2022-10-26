package com.luochao.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class BookDetailVo {
    private String bookId;

    private String bookName;

    private String typeId;

    private String authorId;

    private String authorName;

    private String bookImg;

    private String bookDesc;

    private String typeName;
}
