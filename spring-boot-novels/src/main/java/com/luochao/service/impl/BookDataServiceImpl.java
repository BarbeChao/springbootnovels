package com.luochao.service.impl;

import com.luochao.dao.BookDataMapper;
import com.luochao.domain.BookData;
import com.luochao.service.BookDataService;
import com.luochao.util.SpiderUtil;
import com.luochao.vo.BookDataVo;
import com.luochao.vo.BookDirectoryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDataServiceImpl implements BookDataService {
    @Autowired
    private BookDataMapper bookDataMapper;

    @Override
    public void insertData(String bookId,String bookUrl) {

        List<BookData> bookDataList = SpiderUtil.aa(bookId,bookUrl);

        int sum=0;
        for (BookData bookData : bookDataList) {
            int re =  bookDataMapper.insert(bookData);
            if(re==1){
                System.out.println("成功录入");
                sum+=re;
            }else {
                System.out.println("第"+sum+1+"条数据失败");
            }
        }
        System.out.println("成功录入"+sum+"条数据");
    }

    public List<BookDirectoryVo> selectAlldirectory(String bookId){
        List<BookDirectoryVo> Alldir = bookDataMapper.selectAlldirectory(bookId);
        return Alldir;
    }

    @Override
    public BookDataVo selectBydirectoryId(String directoryId) {
       BookData bookData =  bookDataMapper.selectBydirectoryId(directoryId);
       BookDataVo bookDataVo = new BookDataVo();
        BeanUtils.copyProperties(bookData,bookDataVo);
        return bookDataVo;
    }
}
