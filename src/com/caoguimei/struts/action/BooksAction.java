package com.caoguimei.struts.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.caoguimei.entity.BooksLimit;
import com.caoguimei.entity.BooksPages;
import com.caoguimei.model.Books;
import com.caoguimei.model.User;
import com.caoguimei.model.ViewHistory;
import com.caoguimei.service.BooksService;
import com.caoguimei.service.ViewHistoryService;
import com.opensymphony.xwork2.Action;

@Scope("prototype")
@Controller
public class BooksAction extends BaseAction<Books> implements Action{
	private static final long serialVersionUID = 1L;
	
	private HttpSession session = ServletActionContext.getRequest().getSession();
	
	private HttpServletRequest request = ServletActionContext.getRequest();
	
	@Resource
	private BooksService booksService;
	@Resource
	private ViewHistoryService viewHistoryService;
	private Date date;
	//注入属性当前页
	private int currentPage;
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	//用于限定条件查询的时候存储提交的信息
	private String lable;
	private String lablevalue;
	public String getLable() {
		return lable;
	}
	public void setLable(String lable) {
		this.lable = lable;
	}
	public String getLablevalue() {
		return lablevalue;
	}
	public void setLablevalue(String lablevalue) {
		this.lablevalue = lablevalue;
	}

	//用于实现跳转到添加到图书界面
	public String toAddBook(){
		return "addBookPage";
	}
	
	//实现书籍信息的输入检验以及相应的存储
	public String doAddBook(){
		/*首先检查的是书刊号是不是全部都是数字*/
		String bookid = model.getBookid();
		if(!booksService.isNumber(bookid) && bookid != ""){
			session.setAttribute("errorbookid", "保 证 书 刊 号 全 为 数 字");
			return "addBookPage";
		}
		/*在检验是不是已经存在书籍信息了*/
		if(!booksService.isExit(bookid) && bookid != ""){
			session.setAttribute("errorbookid", "该 书 已 在 数 据 库 中");
			return "addBookPage";
		}
		if(bookid != ""){
			//----------------------------------------后续可以实现添加的时候为零
			session.setAttribute("books", model);
			session.setAttribute("errorbookid", "添加成功");
			//具备实际保存的功能
			model.setViewtimes(0L);//初始话添加书籍的时候的浏览次数为零
			booksService.saveEntity(model);
		}
		
		return "addBookPage";
	}
	
	//抽出相应的方法实现查询指定的信息
	private void getBooksByPage(String bookkind, int currentPage) {
		int pageNo = booksService.getBooksPageNumber(bookkind, 6);
		List<Books> books = booksService.findPagesEntityByHql("Books", "bookkind", bookkind, (currentPage-1)*6, 6);
//		System.out.println(books);
		BooksPages booksPages = new BooksPages(pageNo, currentPage, books);
		session.setAttribute("bookspage", booksPages);
	}
	//首页显示的信息
	public String getFirstPagesBooks(){
		String bookkind = request.getParameter("bookkind");
//		System.out.println(bookkind);
		//显示的首页的信息  也作为第一次转向的页面调用的action
		int currentPage = 1;
		getBooksByPage(bookkind, currentPage);
		return "bookslistpage";
	}
	public String getPrevPageBook(){
		int currentPage = Integer.valueOf(request.getParameter("currentPage"));
		String bookkind = request.getParameter("bookkind");
//		System.out.println(currentPage);
//		System.out.println(bookkind);
		currentPage = currentPage - 1 ;
		getBooksByPage(bookkind, currentPage);
		return "bookslistpage";
	}

	//下一页显示的信息
	public String getNextPageBook(){
		int currentPage = Integer.valueOf(request.getParameter("currentPage"));
		String bookkind = request.getParameter("bookkind");
//		System.out.println(currentPage);
//		System.out.println(bookkind);
		currentPage = currentPage + 1 ;
		getBooksByPage(bookkind, currentPage);
		return "bookslistpage";
	}
	//尾页的信息显示
	public String getLastPageBook(){
		String bookkind = request.getParameter("bookkind");
//		System.out.println(bookkind);
		//显示的首页的信息  也作为第一次转向的页面调用的action
		int currentPage = booksService.getBooksPageNumber(bookkind, 6);;
		getBooksByPage(bookkind, currentPage);
		return "bookslistpage";
	}
	//指定界面的跳转
	public String getIdentityPageBooks(){
		int currentPage = Integer.valueOf(request.getParameter("currentPage"));
		String bookkind = request.getParameter("bookkind");
		getBooksByPage(bookkind, currentPage);
		return "bookslistpage";
	}
	
	//达到查找书籍的页面
	public String toLimitPage(){
		return "searchbookspage";
	}
	
	//按照指定的条件查询书籍 应该可以使用模糊查询
	public String getLimitBooks(){
		String hql = "From Books b where b." + lable + " like '%"+ lablevalue +"%'";
		List<Books> books = booksService.findEntityByHQL(hql);
		BooksLimit booksLimit = new BooksLimit(lable, lablevalue, books);
		session.setAttribute("bookslimit", booksLimit);
		return "searchbookspage";
	}
	
	//实现浏览书籍的时候会累积书籍浏览的次数
	public String viewBook(){
		String bookid = request.getParameter("bookid");
		String bookname = request.getParameter("bookname");
		String hql = "update Books b set b.viewtimes=b.viewtimes+1 where b.bookid = ?";
		booksService.batchEntityByHQL(hql, bookid);
		String hql1 = "From Books b where b.bookid = ?";
		Books book = (Books) booksService.uniqueResult(hql1, bookid);
		session.setAttribute("showonebookinf", book);
		//浏览的信息存储起来
		date = new Date();
		ViewHistory v = new ViewHistory();
		v.setBookname(bookname);
		v.setBookid(bookid);
		v.setDate(date);
		v.setStudentid(((User)session.getAttribute("user")).getStudentid());
		viewHistoryService.saveEntity(v);
		return "showonebookinfo";
	}
	
	//去最近浏览的历史的界面
	public String toViewHisPage(){
		String studentid = ((User)session.getAttribute("user")).getStudentid();
		String hql = "From ViewHistory h where h.studentid = ? order by h.date desc";
		List<ViewHistory> v = viewHistoryService.findEntityByHQL(hql, studentid);
		System.out.println(v);
		session.setAttribute("vlist", v);
		return "viewhistorypage";
	}
	
	
	//热门的书籍的网站
	public String toFireBooksPage(){
		//次数并没有过大的设计  这里面显示的只有十次
		String hql = "From Books b where b.viewtimes > 10 order by b.viewtimes";
		List<Books> bv = booksService.findEntityByHQL(hql);
		session.setAttribute("booksview", bv);
		return "firebookspage";
	}
	
	//随便看看的跳转方法的具体的实现
	/**
	 * 随便看并不是真的随便看看  而是综合有人的浏览纪律
	 * 整理出浏览次数最多的哪一组的实现
	 * @return
	 */
	public String toRandomBooksPage(){
		String hql = "From Books b order by b.viewtimes desc";
		List<Books> books = booksService.findEntityByHQL(hql);
		session.setAttribute("randomlist", books);
		return "randombookspage";
	}
	
	/**
	 * 删除指定书籍浏览的信息纪录
	 * @return
	 */
	public String deleteHistory(){
		String id1 = request.getParameter("id");
		int id = Integer.parseInt(id1);
		System.out.println(id);
		String hql = "delete From ViewHistory h where h.id = ?";
		viewHistoryService.batchEntityByHQL(hql, id);
		return "viewAction";
	}
	//清除个人信息的历史
	public String clearHistory(){
		User user = (User) session.getAttribute("user");
		String studentid = user.getStudentid();
		String hql = "delete from ViewHistory h where h.studentid = ?";
		viewHistoryService.batchEntityByHQL(hql, studentid);
		return "viewAction";
	}

	//准备好显示所有书籍的信息
	public String toBooksListPage(){
		//查询所有的书籍的信息
		List<Books> bs = booksService.findAllEntities();
		session.setAttribute("allbooks", bs);
		return "allbookslistpage";
	}
	//查询显示指定id的详细界面的信息
	public String toDetialBooks(){
		String id1 = request.getParameter("id");
		int id = Integer.parseInt(id1);
		Books book = booksService.getEntity(id);
		session.setAttribute("booksmodify", book);
		return "showbookdetial";
	}
	///删除指定书籍的信息
	public String toDeleteBookbyid(){
		String id1 = request.getParameter("id");
		int id = Integer.parseInt(id1);
		Books book = booksService.getEntity(id);
		booksService.deleteEntity(book);
		return "toShowBooksListAction";
	}
	
	//显示书籍信息--针对后台
		public String getLimitBooksm(){
			if(!lablevalue.equals("")){
				String hql = "From Books b where b." + lable + " like '%"+ lablevalue +"%'";
				List<Books> books = booksService.findEntityByHQL(hql);
				session.setAttribute("allbooks", books);
				session.setAttribute("lablevalue", lablevalue);
				session.setAttribute("lable", lable);
			}else{
				//查询所有的书籍的信息
				List<Books> bs = booksService.findAllEntities();
				session.setAttribute("allbooks", bs);
			}
			return "bookslistpage";
		}
	
}
