package com.example.demo.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.admin.util.SendMail;

@Controller
public class MailController {
    
    @Autowired
    private SendMail sendMail;
    
    @GetMapping("/admin/sendMail")
    public void sendMail() {
    }
    
    @PostMapping("/admin/sendEmail")
    public String sendEmail() {
        sendMail.sendHtml();  // 또는 sendMail.send();
        return "/admin/sendMail";  // 이메일 발송 후 리다이렉트 할 페이지 이름
    }
}
