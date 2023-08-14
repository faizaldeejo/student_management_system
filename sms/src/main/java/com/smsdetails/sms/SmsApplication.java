package com.smsdetails.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.smsdetails.sms.model.smsModel;
import com.smsdetails.sms.repository.smsRepo;

@SpringBootApplication
public class SmsApplication //implements CommandLineRunner
{

	public static void main(String[] args) {
		SpringApplication.run(SmsApplication.class, args);
		//System.out.println("faizal");
		
	}
	/*@Autowired
	private smsRepo smsrepo;
	public void run(String...args) throws Exception{
		smsModel st1=new smsModel("syed","faizal","syedfaizal905@gmail.com");
		smsrepo.save(st1);
		smsModel st2=new smsModel("syed","basha","syedbasha208@gmail.com");
		smsrepo.save(st2);
		

	}*/

}
