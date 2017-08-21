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
		//1).����Configuration���󣺶�Ӧhibernate�Ļ���������Ϣ�� ����ӳ����Ϣ
		Configuration configuration=new Configuration().configure();
		
		//2).����һ��ServiceRegistry;hibernate���κ����úͷ�����Ҫ�ڸö�����ע������Ч
		//�������������hibernate5.02�汾��ǰ�Ĵ�����ʽ��5.02�Ժ�ĵĴ��������������
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		
		//��Session��ֵ
		session=sessionFactory.openSession();
		
		//��������
		transaction=session.beginTransaction();
		
		return session;
	}
	
	public static void clearSession(){
		//5.�ύ����
		transaction.commit();
		//6.�ر�session
		session.close();
		//7.�ر�SessionFactory
		sessionFactory.close();
	}
}
