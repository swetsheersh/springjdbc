package com.spring.jdbc;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entites.Student;

public class Test {

	public static void main(String[] args) {
		System.out.println("Program started.....");
    	//spring jdbc => JdbcTemplate
        AbstractApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        StudentDao impl=(StudentDao) context.getBean("impl");
        Scanner obj=new Scanner(System.in);
        System.out.println("Enter 1 : insert\n 2:update \n 3:Delete \n 4:select\n 5:To Fetch Whole Data");
        int key1=obj.nextInt();
        switch (key1) {
		case 1:
	        //insert data
	        System.out.println("Enter id: ");
	        int a=obj.nextInt();
	        System.out.println("Enter name: ");
	        String b=obj.next();
	        System.out.println("Enter city: ");
	        String c=obj.next();
	        Student student=new Student();
	        student.setId(a);
	        student.setName(b);
	        student.setCity(c);
	
	        int result=impl.insert(student);
	        System.out.println(result+" Data Added");
	        break;
		case 2:
	        //update data
	        Student student1 =new Student();
	        System.out.println("Enter id where to update : ");
	        a=obj.nextInt();
	        System.out.println("Enter updated name: ");
	        b=obj.next();
	        System.out.println("Enter updated city: ");
	        c=obj.next();
	        student1.setId(a);
	        student1.setName(b);
	        student1.setCity(c);
	        int res1=impl.updatetable(student1);
	        System.out.println(res1+" Data Updated...");
	        break;
		case 3:
	        //delete data
	        Student student2 =new Student();
	        System.out.println("Enter id whom to delete : ");
	        a=obj.nextInt();
	        student2.setId(a);
	        int res2=impl.deletedata(student2);
	        System.out.println(res2+" Data Deleted...");
	        break;
		case 4:
			//Feteching single Data
			System.out.println("Enter id whom to Fetch : ");
			int id1=obj.nextInt();
			Student student3=impl.getfromtable(id1);
			System.out.println(student3);
			break;
		case 5:
			//Feteching Whole Data
			System.out.println("Fetching whole Data.....");
			List<Student> students=impl.getallfromtable();
			for(Student s1:students) {
				System.out.println(s1);
			}
			//System.out.println(students);
			break;
		default:
			System.out.println("Invalid Selection....");
			break;
			
        }
	}
}
