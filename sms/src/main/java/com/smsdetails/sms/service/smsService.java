package com.smsdetails.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smsdetails.sms.model.smsModel;
import com.smsdetails.sms.repository.smsRepo;

@Service
public class smsService {
    @Autowired
    private smsRepo smsrepo;

    public List<smsModel> getallstudents(){
        return smsrepo.findAll();
    }

    public void addstudent(smsModel smsmodel){
        smsrepo.
        save(smsmodel);
    }

    public smsModel getstudentbyid(Integer id){
        return smsrepo.findById(id).get();
    }

    public smsModel updatestudent(smsModel smsmodel){
        return smsrepo.save(smsmodel);
    }

    public void deletestudent(Integer id){
        smsrepo.deleteById(id);
    }
}
