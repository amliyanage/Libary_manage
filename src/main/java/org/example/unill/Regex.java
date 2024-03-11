package org.example.unill;

import java.util.regex.Pattern;

public class Regex {
    public static boolean fullName(String name) {
        return !Pattern.matches("([A-Za-z\\s]{3,})", name);
    }

    public static boolean genre(String genre) {
        return !Pattern.matches("([A-Za-z\\s]{3,})", genre);
    }

    public static boolean name(String name) {
        return !Pattern.matches("([A-Za-z]{3,})", name);
    }

    public static boolean mobile(String mobile) {
        return !Pattern.matches("(0\\d{1,9})", mobile);
    }

    public static boolean email(String email) {
        return !Pattern.matches("([A-Za-z0-9]{3,}@[A-Za-z]{3,}\\.[A-Za-z]+)", email);
    }

    public static boolean address(String address) {
        return !Pattern.matches("([A-Za-z0-9/\",\\s]{3,})", address);
    }

    public static boolean houseNo(String no) {
        return !Pattern.matches("([\\d/]+)", no);
    }

    public static boolean street(String street) {
        return !Pattern.matches("([A-Za-z\\s]{3,})", street);
    }

    public static boolean city(String city) {
        return !Pattern.matches("([A-Za-z\\s]{3,})", city);
    }

    public static boolean nic(String nic) {
        return !Pattern.matches("([\\dV]{10,12})", nic);
    }

    public static boolean qty(String qty) {
        return !Pattern.matches("([\\d.]+)", qty);
    }

    public static boolean money(String money) {
        return !Pattern.matches("[\\d.]+", money);
    }

    public static boolean employee(String id) {
        return !Pattern.matches("(E-0\\d+)", id);
    }

    public static boolean userName(String user) {
        return !Pattern.matches("[A-Za-z]+", user);
    }

    public static boolean title(String desc) {
        return !Pattern.matches("[A-Z][A-Za-z\\s]{2,}", desc);
    }

    public static boolean password(String password) {
        return !Pattern.matches("([ -~]{6,20})", password);
    }

    public static boolean otp(String otp) {
        return !Pattern.matches("\\d{6}", otp);
    }
}