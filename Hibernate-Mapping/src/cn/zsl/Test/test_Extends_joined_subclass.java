package cn.zsl.Test;

import org.hibernate.Session;

import cn.zsl.Tools.SessionTools;
import cn.zsl.hibernate.Extends.joinedsubclass.Person;
import cn.zsl.hibernate.Extends.joinedsubclass.Student;

public class test_Extends_joined_subclass {

	public static void main(String[] args) {
		Person person=new Person();
		person.setName("zsl");
		person.setAge(57);
		
		Student stu1=new Student();
		stu1.setName("wc");
		stu1.setAge(21);
		stu1.setSchool("jxau");
		
		Session session=SessionTools.createSession();
		session.save(person);
		session.save(stu1);
		
		SessionTools.clearSession();
	}
	
}
