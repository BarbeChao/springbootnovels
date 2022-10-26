package com.luochao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class BookData {
    private Long id;

    private String bookId;

    private String directoryId;

    private String bookDirectory;

    private String bookContent;


}