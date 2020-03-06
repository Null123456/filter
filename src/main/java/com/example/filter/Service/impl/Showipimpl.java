package com.example.filter.Service.impl;

import com.example.filter.Dao.Showip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Showipimpl implements Showip {

    @Autowired
    Showip showip;

    @Override
    public String selectIp(String ip) {
        return showip.selectIp(ip);
    }
}
