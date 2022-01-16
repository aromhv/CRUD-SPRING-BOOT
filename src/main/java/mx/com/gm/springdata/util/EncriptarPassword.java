package mx.com.gm.springdata.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarPassword {

    public static void main(String[] args) {
        
        var password = "123";
        System.out.println("password: " + password);
        System.out.println("password encriptado: " + encriptarPassword(password));

    }

    public static String encriptarPassword(String password) {
        BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();
        return enconder.encode(password);
    }

}
