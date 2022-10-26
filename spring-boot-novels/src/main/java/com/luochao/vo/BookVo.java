package com.luochao.vo;

import lombok.Data;

@Data
public class BookVo {
/**
 * 这个vo对象是Controller返回视图层的对象
 * domain的是数据库读取出来的实体对象
 * 它可以和domain的实体类属性一致，也可以更改
 */
    private String bookId;

    private String bookName;

    private String authorName;

    private String bookImg;

    private String bookDesc;

    @Override
    public String toString() {
        return "BookVo{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", bookImg='" + bookImg + '\'' +
                ", bookDesc='" + bookDesc + '\'' +
                '}';
    }
}
