package com.luochao.util;

import com.luochao.bean.BookRank;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class RankUtil {
    public  List<BookRank> sort(List<BookRank> arrayList){
        Collections.sort(arrayList);
        return arrayList;
    }

}
