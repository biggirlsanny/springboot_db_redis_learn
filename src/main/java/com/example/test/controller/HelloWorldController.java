package com.example.test.controller;


//import com.example.test.entity.Category;
import com.example.test.entity.Category;
import com.example.test.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping ( "/helloworld" )
public class HelloWorldController {



    @Autowired
    private CategoryService categoryService;



    @RequestMapping("/tpl")
    public String hello(Model model){
        Object category = categoryService.findList();
        model.addAttribute("list",category);
        return "hello";
    }

    @RequestMapping("/tpl/add")
    public String add(Model model){
        Object category = categoryService.findList();
        model.addAttribute("list",category);
        return "add";
    }

    @RequestMapping("/tpl/edit/{id}")
    public Object edit(@PathVariable("id") long id,Model model){
//        long id  = 4;
//        Object category = this.categoryService.findAllById(id);

        Object category = this.categoryService.findAllById(id);
        System.out.print(category);
        model.addAttribute("list",category);
        return "edit";
    }

    @RequestMapping("/tpl/index")
    public String index(Model model){
        Object category = categoryService.findList();
        model.addAttribute("list",category);
        return "index";
    }

}