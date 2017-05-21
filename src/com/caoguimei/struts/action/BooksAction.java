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
	//ע�����Ե�ǰҳ
	private int currentPage;
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	//�����޶�������ѯ��ʱ��洢�ύ����Ϣ
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

	//����ʵ����ת����ӵ�ͼ�����
	public String toAddBook(){
		return "addBookPage";
	}
	
	//ʵ���鼮��Ϣ����������Լ���Ӧ�Ĵ洢
	public String doAddBook(){
		/*���ȼ������鿯���ǲ���ȫ����������*/
		String bookid = model.getBookid();
		if(!booksService.isNumber(bookid) && bookid != ""){
			session.setAttribute("errorbookid", "�� ֤ �� �� �� ȫ Ϊ �� ��");
			return "addBookPage";
		}
		/*�ڼ����ǲ����Ѿ������鼮��Ϣ��*/
		if(!booksService.isExit(bookid) && bookid != ""){
			session.setAttribute("errorbookid", "�� �� �� �� �� �� �� ��");
			return "addBookPage";
		}
		if(bookid != ""){
			//----------------------------------------��������ʵ����ӵ�ʱ��Ϊ��
			session.setAttribute("books", model);
			session.setAttribute("errorbookid", "��ӳɹ�");
			//�߱�ʵ�ʱ���Ĺ���
			model.setViewtimes(0L);//��ʼ������鼮��ʱ����������Ϊ��
			booksService.saveEntity(model);
		}
		
		return "addBookPage";
	}
	
	//�����Ӧ�ķ���ʵ�ֲ�ѯָ������Ϣ
	private void getBooksByPage(String bookkind, int currentPage) {
		int pageNo = booksService.getBooksPageNumber(bookkind, 6);
		List<Books> books = booksService.findPagesEntityByHql("Books", "bookkind", bookkind, (currentPage-1)*6, 6);
//		System.out.println(books);
		BooksPages booksPages = new BooksPages(pageNo, currentPage, books);
		session.setAttribute("bookspage", booksPages);
	}
	//��ҳ��ʾ����Ϣ
	public String getFirstPagesBooks(){
		String bookkind = request.getParameter("bookkind");
//		System.out.println(bookkind);
		//��ʾ����ҳ����Ϣ  Ҳ��Ϊ��һ��ת���ҳ����õ�action
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

	//��һҳ��ʾ����Ϣ
	public String getNextPageBook(){
		int currentPage = Integer.valueOf(request.getParameter("currentPage"));
		String bookkind = request.getParameter("bookkind");
//		System.out.println(currentPage);
//		System.out.println(bookkind);
		currentPage = currentPage + 1 ;
		getBooksByPage(bookkind, currentPage);
		return "bookslistpage";
	}
	//βҳ����Ϣ��ʾ
	public String getLastPageBook(){
		String bookkind = request.getParameter("bookkind");
//		System.out.println(bookkind);
		//��ʾ����ҳ����Ϣ  Ҳ��Ϊ��һ��ת���ҳ����õ�action
		int currentPage = booksService.getBooksPageNumber(bookkind, 6);;
		getBooksByPage(bookkind, currentPage);
		return "bookslistpage";
	}
	//ָ���������ת
	public String getIdentityPageBooks(){
		int currentPage = Integer.valueOf(request.getParameter("currentPage"));
		String bookkind = request.getParameter("bookkind");
		getBooksByPage(bookkind, currentPage);
		return "bookslistpage";
	}
	
	//�ﵽ�����鼮��ҳ��
	public String toLimitPage(){
		return "searchbookspage";
	}
	
	//����ָ����������ѯ�鼮 Ӧ�ÿ���ʹ��ģ����ѯ
	public String getLimitBooks(){
		String hql = "From Books b where b." + lable + " like '%"+ lablevalue +"%'";
		List<Books> books = booksService.findEntityByHQL(hql);
		BooksLimit booksLimit = new BooksLimit(lable, lablevalue, books);
		session.setAttribute("bookslimit", booksLimit);
		return "searchbookspage";
	}
	
	//ʵ������鼮��ʱ����ۻ��鼮����Ĵ���
	public String viewBook(){
		String bookid = request.getParameter("bookid");
		String bookname = request.getParameter("bookname");
		String hql = "update Books b set b.viewtimes=b.viewtimes+1 where b.bookid = ?";
		booksService.batchEntityByHQL(hql, bookid);
		String hql1 = "From Books b where b.bookid = ?";
		Books book = (Books) booksService.uniqueResult(hql1, bookid);
		session.setAttribute("showonebookinf", book);
		//�������Ϣ�洢����
		date = new Date();
		ViewHistory v = new ViewHistory();
		v.setBookname(bookname);
		v.setBookid(bookid);
		v.setDate(date);
		v.setStudentid(((User)session.getAttribute("user")).getStudentid());
		viewHistoryService.saveEntity(v);
		return "showonebookinfo";
	}
	
	//ȥ����������ʷ�Ľ���
	public String toViewHisPage(){
		String studentid = ((User)session.getAttribute("user")).getStudentid();
		String hql = "From ViewHistory h where h.studentid = ? order by h.date desc";
		List<ViewHistory> v = viewHistoryService.findEntityByHQL(hql, studentid);
		System.out.println(v);
		session.setAttribute("vlist", v);
		return "viewhistorypage";
	}
	
	
	//���ŵ��鼮����վ
	public String toFireBooksPage(){
		//������û�й�������  ��������ʾ��ֻ��ʮ��
		String hql = "From Books b where b.viewtimes > 10 order by b.viewtimes";
		List<Books> bv = booksService.findEntityByHQL(hql);
		session.setAttribute("booksview", bv);
		return "firebookspage";
	}
	
	//��㿴������ת�����ľ����ʵ��
	/**
	 * ��㿴�����������㿴��  �����ۺ����˵��������
	 * ������������������һ���ʵ��
	 * @return
	 */
	public String toRandomBooksPage(){
		String hql = "From Books b order by b.viewtimes desc";
		List<Books> books = booksService.findEntityByHQL(hql);
		session.setAttribute("randomlist", books);
		return "randombookspage";
	}
	
	/**
	 * ɾ��ָ���鼮�������Ϣ��¼
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
	//���������Ϣ����ʷ
	public String clearHistory(){
		User user = (User) session.getAttribute("user");
		String studentid = user.getStudentid();
		String hql = "delete from ViewHistory h where h.studentid = ?";
		viewHistoryService.batchEntityByHQL(hql, studentid);
		return "viewAction";
	}

	//׼������ʾ�����鼮����Ϣ
	public String toBooksListPage(){
		//��ѯ���е��鼮����Ϣ
		List<Books> bs = booksService.findAllEntities();
		session.setAttribute("allbooks", bs);
		return "allbookslistpage";
	}
	//��ѯ��ʾָ��id����ϸ�������Ϣ
	public String toDetialBooks(){
		String id1 = request.getParameter("id");
		int id = Integer.parseInt(id1);
		Books book = booksService.getEntity(id);
		session.setAttribute("booksmodify", book);
		return "showbookdetial";
	}
	///ɾ��ָ���鼮����Ϣ
	public String toDeleteBookbyid(){
		String id1 = request.getParameter("id");
		int id = Integer.parseInt(id1);
		Books book = booksService.getEntity(id);
		booksService.deleteEntity(book);
		return "toShowBooksListAction";
	}
	
	//��ʾ�鼮��Ϣ--��Ժ�̨
		public String getLimitBooksm(){
			if(!lablevalue.equals("")){
				String hql = "From Books b where b." + lable + " like '%"+ lablevalue +"%'";
				List<Books> books = booksService.findEntityByHQL(hql);
				session.setAttribute("allbooks", books);
				session.setAttribute("lablevalue", lablevalue);
				session.setAttribute("lable", lable);
			}else{
				//��ѯ���е��鼮����Ϣ
				List<Books> bs = booksService.findAllEntities();
				session.setAttribute("allbooks", bs);
			}
			return "bookslistpage";
		}
	
}
