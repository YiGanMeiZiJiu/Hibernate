package cn.zsl.Test;

import org.hibernate.Session;

import cn.zsl.Tools.SessionTools;
import cn.zsl.hibernate.foreign.one2one.Department;
import cn.zsl.hibernate.foreign.one2one.Manager;

public class test_Primary_one2one {

	public static void main(String[] args) {
		Manager manager=new Manager();
		manager.setMgrName("zsl");
		
		Department dept1=new Department();
		dept1.setDeptName("ºº ı≤ø");
		
		manager.setDept(dept1);
		dept1.setMgr(manager);
		
		Session session=SessionTools.createSession();
//		session.save(manager);
//		session.save(dept1);
		
		Department dept=(Department) session.get(Department.class,1);
		System.out.println(dept.getDeptName());
		
		Manager mgr=dept.getMgr();
		System.out.println(mgr.getMgrName());
		SessionTools.clearSession();
	}
}
