package com.hoho.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hoho.test.bean.Test;
@Repository
public interface TestRepository extends CrudRepository<Test, Long> {
	@Query(value = "select * From Test", nativeQuery = true)
	public List<Test> find();
	@Modifying(clearAutomatically = true) @Query(value = "update test set name = ? where id = ?", nativeQuery = true)@Transactional
	public void update(String name,Long id);

}
