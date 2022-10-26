package com.luochao.util;

import com.luochao.domain.BookData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;


public class SpiderUtil {

    public static List<BookData> aa(String bookId , String bookUrl){

        List<BookData> bookDataList = new ArrayList<>();
        String newBookUrl= "https://fanqienovel.com/page/"+bookUrl;
        BookData bookData = null;
        int common = 100000;
        try {
            Document document = Jsoup.connect(newBookUrl).get();
            Elements elements = document.select("div.chapter-item > a");
            for (Element element : elements) {
                String linkHref = element.attr("href");
                String linkTitle = element.text();
                System.out.println(linkTitle);
                String Doc = "https://fanqienovel.com"+linkHref;
                bookData = new BookData();
                Document DOCWen = Jsoup.connect(Doc).get();
                Elements elements1 = DOCWen.select("div.muye-reader-content > div > p");
                bookData.setBookId(bookId);
                bookData.setBookDirectory(linkTitle);

                bookData.setDirectoryId(bookId+common);
                common+=1;
                bookData.setBookContent(elements1.text());
                bookDataList.add(bookData);

                Thread.sleep(1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookDataList;
    }
}
