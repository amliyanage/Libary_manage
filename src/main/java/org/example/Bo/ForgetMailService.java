package org.example.Bo;

public interface ForgetMailService extends SuperService{
    boolean sendEmail(String email, String otp);
}
