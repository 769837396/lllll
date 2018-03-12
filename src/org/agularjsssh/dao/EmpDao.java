package org.agularjsssh.dao;

import java.util.List;

import org.agularjsssh.pojo.Emp;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDao extends HibernateDaoSupport {

	@Autowired
	public void set(SessionFactory sf) {
		super.setSessionFactory(sf);
	}

	public List<Emp> findAll() {
		HibernateTemplate jdbc = this.getHibernateTemplate();
		List<Emp> el = jdbc.loadAll(Emp.class);
		return el;
	}

	public void deleteEmpWithEid(String eid) {
		HibernateTemplate jdbc = this.getHibernateTemplate();
		Emp emp = new Emp();
		emp.setEid(Integer.valueOf(eid));
		jdbc.delete(emp);
	}

}
