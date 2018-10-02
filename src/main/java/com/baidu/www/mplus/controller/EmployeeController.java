package com.baidu.www.mplus.controller;


import com.baidu.www.mplus.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {


    @Autowired
    private IEmployeeService employeeService;


    @ResponseBody
    @RequestMapping(value="/list",method = RequestMethod.GET)
    public Object list(){

//        return employeeService.list();

        return null;
    }




}
