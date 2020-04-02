package com.sofency.ssm.service.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.sofency.ssm.service.interfaces.SendMailUtilService;

public class SendMailUtilServiceImpl implements SendMailUtilService{
    private  JavaMailSender javaMailSender;//在spring中配置的邮件发送的bean
	@Autowired
	public SendMailUtilServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public String sendMail(String candidateEmail, String candidateName) {
		MimeMessage mMessage=javaMailSender.createMimeMessage();//创建邮件对象
        MimeMessageHelper mMessageHelper;
        InputStream inputStream = null;
        try {
			inputStream = new BufferedInputStream(new FileInputStream(new File("H:\\eclipse_workspace\\EngineerHub\\WebContent\\WEB-INF\\classes\\mail.properties")));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        Properties prop = new Properties();
        String from;
        //从配置文件中拿到发件人邮箱地址
        try {
			prop.load(new InputStreamReader(inputStream, "utf-8"));
			from = prop.get("mail.smtp.username")+"";
            mMessageHelper=new MimeMessageHelper(mMessage,true);
            mMessageHelper.setFrom(from);//发件人邮箱
            mMessageHelper.setTo(candidateEmail);//收件人邮箱
            mMessageHelper.setSubject("简历通过");//邮件的主题
            mMessageHelper.setText(candidateName+"同学你好，恭喜你的简历已经被审核通过，我们会在24小时之内对你进行电话面试，请注意接听，预祝加入我们这个大家庭");//邮件的文本内容，true表示文本以html格式打开
	        javaMailSender.send(mMessage);//发送邮件
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
        return "success";
	}
}
