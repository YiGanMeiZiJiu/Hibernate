package cn.zsl.hibernate.Shuangxiang.n2n;

import java.util.HashSet;
import java.util.Set;

public class Category {

	private int id;
	private String name;
	private Set<Item> Items=new HashSet();
	
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
	public Set<Item> getItems() {
		return Items;
	}
	public void setItems(Set<Item> items) {
		Items = items;
	}
}
