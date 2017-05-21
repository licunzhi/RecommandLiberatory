package com.caoguimei.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caoguimei.dao.BaseDao;
import com.caoguimei.dao.impl.BooksDaoImpl;
import com.caoguimei.model.Books;
import com.caoguimei.service.BooksService;


@Service("booksService")
public class BooksServiceImpl extends BaseServiceImpl<Books> implements BooksService{
	

	@Resource(name="booksDao")
	public void setDao(BaseDao<Books> dao) {
		super.setDao(dao);
	}

	/**
	 * 判断是不是全为数字的书刊号
	 */
	@Override
	public boolean isNumber(String bookid) {
		  Pattern pattern = Pattern.compile("[0-9]*");
          Matcher isNum = pattern.matcher(bookid);
          if( !isNum.matches() )
          {
                return false;
          }
		return true;
	}

	/**
	 * 目的就是为了保证书及的唯一性
	 */
	@Override
	public boolean isExit(String bookid) {
		String hql = "FROM Books b WHERE b.bookid = ?";
		List<Books> list = this.findEntityByHQL(hql, bookid);
		if(list.size() == 0 || list == null){
			return true;
		}
		return false;
	}

	/**
	 * 得到指定书本信息的数量
	 */
	@Override
	public int getBooksNumber(String bookkind) {
		String hql = "From Books b where b.bookkind = ?";
		List<Books> list = this.findEntityByHQL(hql, bookkind);
		return list.size();
	}
	
	/**
	 * 得到书籍的显示的页数
	 */
	@Override
		public int getBooksPageNumber(String bookkind,int maxResults){
			int totalNumber = this.getBooksNumber(bookkind);
			int pagesNumber = totalNumber/maxResults;
			if(totalNumber%maxResults != 0)pagesNumber = pagesNumber + 1;
			return pagesNumber;
		}
	
	
}
