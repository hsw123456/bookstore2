package com.hsw.bookstore.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHibernateTest {
	
	
	private ApplicationContext ctx = null;
	
	{
		
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void testDataSource() throws SQLException{
		
	DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource.getConnection());
		
		SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
		System.out.println(sessionFactory);
		
		
	}
	
	@Test
	public void testBookDaoImpl(){
		
		
		
	}

}
