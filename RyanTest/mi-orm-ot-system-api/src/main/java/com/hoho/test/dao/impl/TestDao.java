package com.hoho.test.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoho.test.bean.Test;
import com.hoho.test.dao.TestRepository;

@Service
public class TestDao {
	@Autowired
    private TestRepository testRepository;
	
	public List<Test> findAll(){
		return (List<Test>) testRepository.findAll();
	}
	public void add(Test t){
		testRepository.save(t);
	}
	
}
