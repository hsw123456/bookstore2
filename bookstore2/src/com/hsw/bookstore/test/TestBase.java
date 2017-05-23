package com.hsw.bookstore.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

public class TestBase {
	
	@Test
	public void test(){
		
		Class c = TestImpl.class;
		
		Type type = c.getGenericSuperclass();
		
		ParameterizedType pt = (ParameterizedType) type;
		
		Type[] arguments = pt.getActualTypeArguments();
		
		for(int i = 0; i< arguments.length;i++){
			System.out.println(arguments[i]);
		}
		
	}

}
