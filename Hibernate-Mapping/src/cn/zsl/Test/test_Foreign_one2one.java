package cn.zsl.Test;

import org.hibernate.Session;

import cn.zsl.Tools.SessionTools;
import cn.zsl.hibernate.foreign.one2one.Department;
import cn.zsl.hibernate.foreign.one2one.Manager;

public class test_Foreign_one2one {

	public static void main(String[] args) {
		Manager manager = new Manager();
		manager.setMgrName("wc");
		
		Department department = new Department();
		department.setDeptName("·şÎñ²¿");
		
		manager.setDept(department);
		
		department.setMgr(manager);
		
		Session session=SessionTools.createSession();
		session.save(department);
		session.save(manager);
		
		Department dept=(Department) session.get(Department.class, 1);
		
		SessionTools.clearSession();
		
		Manager mgr=dept.getMgr();	
		System.out.println(mgr.getMgrName());
		
//		SessionTools.clearSession();
	}
	
}
