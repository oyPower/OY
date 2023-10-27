package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.User;
import service.UserService;
import java.io.*;

@Controller
public class EnrollController {

    @Autowired
    private UserService userService;

    @RequestMapping("enroll")
    public ModelAndView Insett(String us_name, String us_mobile, String us_password){
        Boolean success = userService.insertUserByNameAndMobileAndPassword(us_name, us_mobile, us_password);
        ModelAndView modelAndView = new ModelAndView();
        if(!success){
            modelAndView.setViewName("index");
        }else{
            User user = userService.findUserByMobileAndPassword(us_mobile, us_password);
            modelAndView.setViewName("user");
            modelAndView.addObject("user",user);
        }
        return modelAndView;
    }
}
