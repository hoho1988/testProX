package com.hoho.test.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoho.test.bean.Test;
import com.hoho.test.dao.TestRepository;
@Service
public class Test2Dao{

	@Autowired
    private TestRepository testRepository;

	public List<Test> find() {
		
		return testRepository.find();
	}
	public void update(Test t){
		testRepository.update(t.getName(),t.getId());
	}

}
