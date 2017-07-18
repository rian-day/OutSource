package com.hyh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
	@Autowired
    private JavaMailSender mailSender; //自动注入的Bean

    @Value("${spring.mail.username}")
    private String Sender; //读取配置文件中的参数

    
    public void sendSimpleMail(String mail,String yzm){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(Sender);
        message.setTo(mail); //自己给自己发送邮件
        message.setSubject("Lanou考试系统");
        message.setText("<center>您的验证码为:"+yzm+"</center>");
        mailSender.send(message);
    }
}
