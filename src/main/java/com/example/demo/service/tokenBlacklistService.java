package com.example.demo.service;


import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

@Service

public class tokenBlacklistService {

    public HashMap<String, Date> blacklist = new HashMap<>();

    public void BlacklistToken ( String token , Date expiryDate){
        blacklist.put(token,expiryDate);
    }
    public boolean isTokenBlacklist (String token){
        Date expiry= blacklist.get(token);

        if (expiry==null){
            return false;
        }
        if (expiry.before(new Date())) {
            blacklist.remove(token);
        }
            return true;
        }
}
