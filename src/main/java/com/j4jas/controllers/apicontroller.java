package com.j4jas.controllers;

import com.j4jas.library.Messager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Samuel.Iheadindu on 13/09/2017.
 */
@RestController
public class apicontroller {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sendMessage(){
        System.out.println("Something beautiful is happening here.");
        String txt = "This is to test and be sure that we can send sms";
        Messager.sendSms("2348099260753", txt);
        return "You are here finally";
    }
}
