package com.luochao.util;

import nl.siegmann.epublib.domain.*;
import nl.siegmann.epublib.epub.EpubReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class epublibUtil {
    public static void main(String[] args) {
        File file = new File("epub/三体.epub");
        InputStream inputStream = null;
        EpubReader reader = new EpubReader();
        try {
            inputStream = new FileInputStream(file);
            Book book = reader.readEpub(inputStream);

            //获取元数据
            Metadata metadata = book.getMetadata();
            System.out.println(metadata.getAuthors());
            System.out.println(metadata.getDescriptions());
            System.out.println(metadata.getFirstTitle());

            //获取资源
            Resources resources = book.getResources();
            System.out.println("资源个数"+resources.size());

            //获取骨骼
            Spine spine = book.getSpine();
            System.out.println("骨骼个数"+spine.size());

            //获取目录
            TableOfContents tableOfContents = book.getTableOfContents();
            System.out.println(tableOfContents.getAllUniqueResources());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
