import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.caoguimei.model.User;
import com.caoguimei.service.BooksService;
import com.caoguimei.tools.StringUtil;

public class TestRegister {
	
	private static BooksService bs;
	
	@BeforeClass
	public static void initUserService(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		bs = (BooksService) ac.getBean("booksService");
	}
	
	/**
	 * 使用的junit单元测试  测试分页代码是否能够实现
	 */
	@Test
	public void getPagesEntity(){
		System.out.println(bs.findPagesEntityByHql("Books","bookkind","计算机科学与技术", 0, 2));
	}
	
	@Test
	public void testArr(){
		String[] arr = {"a","b","c"};
		String str = StringUtil.arr2specialstr(arr);
		System.out.println(str);
	}
	

}
