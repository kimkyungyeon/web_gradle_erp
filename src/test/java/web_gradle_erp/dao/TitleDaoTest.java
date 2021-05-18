package web_gradle_erp.dao;



import java.sql.Connection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import web_gradle_erp.JdbcUtil;
import web_gradle_erp.dao.impl.TitleDaoImpl;
import web_gradle_erp.dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TitleDaoTest {
	private static Connection con;
	private static TitleDaoImpl dao = TitleDaoImpl.getInstance();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		con = JdbcUtil.getConnection();
		dao.setCon(con);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		con.close();
	}

	

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectTitleByAll() {
		System.out.printf("%s()%n","test01SelectTitleByAll");
		List<Title> list = dao.selectTitleByAll();
		Assert.assertNotNull(list);
		
		list.parallelStream().forEach(System.out::println);
		
		
	}

	@Test
	public void test04SelectTitleByNo() {
		System.out.printf("%s()%n","test04SelectTitleByNo");
		Title searchTitle = new Title(1);
		Title title = dao.selectTitleByNo(searchTitle);
		Assert.assertNotNull(title);
		System.out.println(title);
				

	}

	@Test
	public void test02InsertTitle() {
	}

	@Test
	public void test03UpdateTitle() {
	}

	@Test
	public void test05DeleteTitle() {
	}

}
