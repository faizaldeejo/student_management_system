package com.smsdetails.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.smsdetails.sms.model.smsModel;
import com.smsdetails.sms.service.smsService;


//@RestController
@Controller
//@RequestMapping("students")
public class smsController {
    @Autowired
    private smsService smsservice;
    
    @GetMapping("/students")
    public String getallstudents(Model model){
        model.addAttribute("allstudents",smsservice.getallstudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String createstudentform(Model model){
        smsModel smsmodel=new smsModel();
        model.addAttribute("smsmodel",smsmodel);
        return "create";
    }

    @PostMapping("addstudent")
    public String addstudent(@ModelAttribute("smsmodel") smsModel smsmodel){
        smsservice.addstudent(smsmodel);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editstudentform(@PathVariable Integer id, Model model){
        model.addAttribute("student",smsservice.getstudentbyid(id));
        return "editstudent";
    }

    @PostMapping("/students/{id}")
    public String updatestudent(@PathVariable Integer id, @ModelAttribute("smsmodel") smsModel smsmodel, Model model){
        
        //get student from database by id
        smsModel existingstudent =smsservice.getstudentbyid(id);
        existingstudent.setId(id);
        existingstudent.setFirstname(smsmodel.getFirstname());
        existingstudent.setLastname(smsmodel.getLastname());
        existingstudent.setEmail(smsmodel.getEmail());

        //save updated student object
        smsservice.updatestudent(existingstudent);
        return "redirect:/students";

    }

    //handler method to handle delete student request
    @GetMapping("/students/{id}")
    public String deletestudent(@PathVariable Integer id){
        smsservice.deletestudent(id);
        return "redirect:/students";
    }
}
