package com.example.test.controller;


//import com.example.test.entity.Category;
import com.example.test.entity.Category;
import com.example.test.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping ( "/hello" )
public class HelloController {

    @RequestMapping("/say")
    public String say(){
        return "hello world";
    }

    @Autowired
    private CategoryService categoryService;



//    @RequestMapping("/{name}")
//    public Category findUseByName(@PathVariable String name){
//        return categoryService.getUserByName(name);
//    }
//
//    @RequestMapping("/code/{code}")
//    public Category findUseByCode(@PathVariable String code){
//        return categoryService.getUserByCode(code);
//    }

    @RequestMapping("/all")
    public Object findList(){
        return categoryService.findList();
    }

    @RequestMapping("/del/{id}")
    public String del(@PathVariable Long id){
        this.categoryService.deleteById(id);
        return "yes";
    }

    @RequestMapping("/delete/{code}")
    public void delete(@PathVariable String code){
        this.categoryService.deleteByCode(code);
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public Category add(Category category){
        return categoryService.addCategory(category);
    }

    @PostMapping("/save")
    public Category save(Category category){
        return categoryService.addCategory(category);
    }


    @GetMapping("/query")
    public Object findByPage(Integer page, HttpServletResponse response){

        response.setHeader("Access-Control-Allow-Origin","*");
        if(page==null||page<=0){
            page=0;
        }else {
            page -=1;
        }
        return categoryService.findAll(page,5);
    }



    @RequestMapping("/test/edit/{id}")
    public Object edit(@PathVariable("id") long id, Model model){
//        long id  = 4;
//        Object category = this.categoryService.findAllById(id);

        Object category = this.categoryService.findAllById(id);
        return category;

    }
}