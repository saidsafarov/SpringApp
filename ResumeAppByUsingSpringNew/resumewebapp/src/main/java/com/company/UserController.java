package com.company;

import com.company.sevice.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
@RequestMapping("/")
    public String showPage() {
        return "users";
    }

}