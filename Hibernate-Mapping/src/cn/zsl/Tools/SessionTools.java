package cn.zsl.Tools;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SessionTools {
	private static SessionFactory sessionFactory; 
	private static Session session;
	private static Transaction transaction;
	
	public static Session createSession(){
		//1).创建Configuration对象：对应hibernate的基本配置信息和 对象映射信息
		Configuration configuration=new Configuration().configure();
		
		//2).创建一个ServiceRegistry;hibernate的任何配置和服务都需要在该对象上注册后才有效
		//这个创建方法是hibernate5.02版本以前的创建方式，5.02以后的的创建方法不是这个
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		
		//给Session赋值
		session=sessionFactory.openSession();
		
		//开启事务
		transaction=session.beginTransaction();
		
		return session;
	}
	
	public static void clearSession(){
		//5.提交事务
		transaction.commit();
		//6.关闭session
		session.close();
		//7.关闭SessionFactory
		sessionFactory.close();
	}
}
