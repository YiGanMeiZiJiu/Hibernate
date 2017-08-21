package cn.zsl.hibernate.Shuangxiang.n2n;

import java.util.HashSet;
import java.util.Set;

public class Item {

	private int id;
	private String name;
	private Set<Category> Categories=new HashSet();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Category> getCategories() {
		return Categories;
	}
	public void setCategories(Set<Category> categories) {
		Categories = categories;
	}
	
	
	
}
