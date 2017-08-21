package cn.zsl.Test;

import org.hibernate.Session;

import cn.zsl.Tools.SessionTools;
import cn.zsl.hibernate.Shuangxiang.n21.Customer;
import cn.zsl.hibernate.Shuangxiang.n21.Order;

public class test_ShuangXiang_n21 {

	public static void main(String[] args) {
		Customer customer=new Customer();
		customer.setCustomerName("zsl");
	
		Order order1=new Order();		
		order1.setOrderName("youting");
		
		Order order2=new Order();
		order2.setOrderName("sirenfeiji");
		
		order1.setCustomer(customer);
		order2.setCustomer(customer);
		
		customer.getOrder().add(order1);
		customer.getOrder().add(order2);
		
		Session session=SessionTools.createSession();
		
		session.save(customer);
		session.save(order1);
		session.save(order2);
		Customer customer1=(Customer) session.get(Customer.class, 1);
		
		session.delete(customer1);
		
		SessionTools.clearSession();
	}
	
}
