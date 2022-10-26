package com.luochao.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class RankVo {
    private String bookId;
    private String bookName;
    private String authorName;
    private String bookImg;
}
