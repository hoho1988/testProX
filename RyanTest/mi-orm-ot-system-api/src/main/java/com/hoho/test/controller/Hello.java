package com.hoho.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hoho.test.bean.Test;
import com.hoho.test.dao.impl.Test2Dao;
import com.hoho.test.dao.impl.TestDao;


@Controller
public class Hello {
	@Autowired
	private TestDao testDao;
	@Autowired
	private Test2Dao test2Dao;
	@RequestMapping("/findAll_OT")
	@ResponseBody
	public List<Test> findAll_OT(){
		return test2Dao.find();
	}
	@RequestMapping("/add_OT")
	@ResponseBody
	public String add_OT(String name){
		Test t = new Test();
		t.setName(name);
		testDao.add(t);
		return "add seccess!!!";
	}
	@RequestMapping("/update_OT")
	@ResponseBody
	public String update_OT(String name,Long id){
		System.out.println(name+"------------------------------------");
		test2Dao.update(new Test(5l, "ccccc"));
		test2Dao.update(new Test(id, name));
		
		test2Dao.update(new Test(6l, "ddddd"));
		return "update seccess!!!";
	}
	@RequestMapping("/test")
	@ResponseBody
	public String test(String name) throws Exception{
		this.findAll_OT();
		name = "xuxuan";
        new Thread(new Runnable() {
            @Override
            public void run() {
            	Test t = new Test();
        		t.setName("dfghgfhfg");
            	testDao.add(t);
            }
        }).start();
        Thread.sleep(1000);
        Test t = new Test();
		t.setName("hahahahahah");
    	testDao.add(t);
        return "testVersion";
	}
	
	
}
