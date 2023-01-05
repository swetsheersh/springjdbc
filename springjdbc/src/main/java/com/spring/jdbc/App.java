package com.spring.jdbc;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Spring Jdbc
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Program started.....");
    	//spring jdbc => JdbcTemplate
        AbstractApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        JdbcTemplate template=(JdbcTemplate)context.getBean("jdbcTemplate");
        
        //insert query
        String query="insert into student(id,name,city) values(?,?,?)";
        
        //fire the query
        int result = template.update(query,605,"purushuttam mishra","New Delhi");
        System.out.println("Updated......");
    }
}
