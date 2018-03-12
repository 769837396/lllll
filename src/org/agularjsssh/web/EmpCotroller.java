package org.agularjsssh.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.agularjsssh.pojo.Emp;
import org.agularjsssh.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin("*")
public class EmpCotroller {

	@Autowired
	private EmpService es;

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody

	public List<Emp> fn1(HttpServletResponse response) {
		// response.setHeader("Access-Control-Allow-Origin", "*");
		List<Emp> el = es.findAll();
		return el;
	}

	@RequestMapping("/delete/{eid}")
	@ResponseBody
	public String fn2(HttpServletResponse response, @PathVariable("eid") String eid) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		es.deleteEmpWithEid(eid);
		return "{}";
	}

}
