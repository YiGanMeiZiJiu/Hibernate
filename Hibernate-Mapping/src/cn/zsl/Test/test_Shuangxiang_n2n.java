package cn.zsl.Test;

import java.util.Set;

import org.hibernate.Session;

import cn.zsl.Tools.SessionTools;
import cn.zsl.hibernate.Shuangxiang.n2n.Category;
import cn.zsl.hibernate.Shuangxiang.n2n.Item;

public class test_Shuangxiang_n2n {

	public static void main(String[] args) {
		Category category1=new Category();
		Category category2=new Category();
		
		category1.setName("C-AA");
		category2.setName("C-BB");
		
		Item item1=new Item();
		Item item2=new Item();
		
		item1.setName("I-AA");
		item2.setName("I-BB");
		
		category1.getItems().add(item1);
		category1.getItems().add(item2);
		
		category2.getItems().add(item1);
		category2.getItems().add(item2);
		
		item1.getCategories().add(category2);
		item2.getCategories().add(category1);
		
		item1.getCategories().add(category1);
		item2.getCategories().add(category2);
		
		Session session = SessionTools.createSession();
		
		session.save(category1);
		session.save(category2);
		session.save(item1);
		session.save(item2);
		
		Category cate1=(Category) session.get(Category.class, 1);
		
		Set<Item> set=cate1.getItems();
		
		System.out.println(set.size());
		
		SessionTools.clearSession();
	}
	
}
