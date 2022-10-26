package com.luochao.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class BookRank implements Comparable<BookRank>{
    private String id;
    private int num;

    @Override
    public String toString() {
        return "BookRank{" +
                "id='" + id + '\'' +
                ", num=" + num +
                '}';
    }

    @Override
    public int compareTo(BookRank o) {
        return o.getNum()-this.num;
    }
}
