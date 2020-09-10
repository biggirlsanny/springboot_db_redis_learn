package com.example.test.dao;

import com.example.test.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public interface CategoryDao extends JpaRepository<Category, Long> {
    //查
    Category findUserByname(String name);

    Category getUserById(Long id);

    @Query(value="select * from category where code=:code", nativeQuery = true)
     Category findByCode(@Param("code") String code);

    List<Category> findAll();
    List<Category> findAllById(Long id);

    //删
    void deleteById(Long id);

    @Transactional
    void deleteByCode(String code);

    //增
    //List<Category> save(object category);

    //改



}
