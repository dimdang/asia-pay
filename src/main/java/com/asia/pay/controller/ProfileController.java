package com.asia.pay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dang Dim
 * Date     : 3/26/19, 12:11 PM
 * Email    : dangdim02@gmail.com
 */

@RestController
public class ProfileController {

    @GetMapping("/free")
    public String profile(){
        return "Free Trial";
    }

    @GetMapping("/secure")
    public String secure(){
        return "Activation...!";
    }
}
