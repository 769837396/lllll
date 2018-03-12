package org.agularjsssh.service;

import java.util.List;

import org.agularjsssh.dao.EmpDao;
import org.agularjsssh.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmpService {

	@Autowired
	private EmpDao ed;

	public List<Emp> findAll() {
		List<Emp> el = ed.findAll();
		return el;
	}

	public void deleteEmpWithEid(String eid) {
		 ed.deleteEmpWithEid(eid);
		
	}

}
