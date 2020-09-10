package com.example.test.service;

import com.example.test.entity.Category;
import com.example.test.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    public Category getUserByName(String name){
        return categoryDao.findUserByname(name);
    }

    public Category getUserByCode(String code){
        return categoryDao.findByCode(code);
    }

    public Object findList(){
        return categoryDao.findAll();
    }

    public void deleteById(Long id){
        categoryDao.deleteById(id);
    }

    public void deleteByCode(String code){
        categoryDao.deleteByCode(code);
    }

    public Category addCategory(Category category) {
        return categoryDao.save(category);
    }

    public Object findAll(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page,pageSize);
        return categoryDao.findAll(pageable);
    }


    public Object findAllById(Long id) {
        return categoryDao.getUserById(id);
    }

}
