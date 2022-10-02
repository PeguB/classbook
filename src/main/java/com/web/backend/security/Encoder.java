package com.web.backend.security;

import lombok.Getter;
import lombok.Setter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Configuration
@Setter
@Getter
public class Encoder {

    @Bean
    public Encoder returnEncoder() {
        return new Encoder();
    }

    public String encrypt(String input) {
        try {

            MessageDigest msgDst = MessageDigest.getInstance("MD5");
            byte[] msgArr = msgDst.digest(input.getBytes());
            BigInteger bi = new BigInteger(1, msgArr);
            String hshtxt = bi.toString(16);
            while (hshtxt.length() < 32) {
                hshtxt = "0" + hshtxt;
            }
            return hshtxt;
        } catch (NoSuchAlgorithmException abc) {
            throw new RuntimeException(abc);
        }
    }
}
