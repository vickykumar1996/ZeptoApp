package com.zepto;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class A
{
    public static void main(String[] args) {
//        boolean checkpw = BCrypt.checkpw("ram", "'$2a$05$.DuAR/BNb7NEXuXLp1Mnge45WHpJD3zP3CACzS3ApANbokjwPGa9G'");
//        System.out.println(checkpw);
        String hashpw = BCrypt.hashpw("ram", BCrypt.gensalt(5));
        System.out.println(hashpw);
    }
}
