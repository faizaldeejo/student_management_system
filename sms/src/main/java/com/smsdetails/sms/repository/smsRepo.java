package com.smsdetails.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smsdetails.sms.model.smsModel;

@Repository
public interface smsRepo extends JpaRepository<smsModel,Integer>{
    
}
