package cn.zsl.Test;

import org.hibernate.Session;

import cn.zsl.Tools.SessionTools;
import cn.zsl.hibernate.DanXiang.n21.Customer;
import cn.zsl.hibernate.DanXiang.n21.Order;

public class test_DanXiang_n21 {

	public static void main(String[] args) {
		Customer customer=new Customer();
		customer.setCustomerName("zsl");
		
		Order order1=new Order();
		Order order2=new Order();
		order1.setOrderName("youting");
		order2.setOrderName("sirenfeiji");
		
		
		order1.setCustomer(customer);
		order2.setCustomer(customer);
		
		Session session=SessionTools.createSession();
		session.save(customer);
		session.save(order1);
		session.save(order2);
		
		SessionTools.clearSession();
		
	}
	
}
