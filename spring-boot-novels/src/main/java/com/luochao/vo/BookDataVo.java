package com.luochao.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class BookDataVo {

    private String bookId;

    private String directoryId;

    private String bookDirectory;

    private String bookContent;
}
