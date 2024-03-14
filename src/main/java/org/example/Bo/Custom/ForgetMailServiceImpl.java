package org.example.Bo.Custom;

import org.example.Bo.ForgetMailService;
import org.example.Bo.MemberService;
import org.example.Controller.Email.EmailController;
import org.example.Controller.ForgetPassWord.ConfirmForgetPassWordFormController;
import org.example.Controller.ForgetPassWord.ForgetPassWordFormController;
import org.example.Controller.LoginPageController;
import org.example.Dao.AdminRepository;
import org.example.Dao.Custom.RepositoryFactory;
import org.example.Dao.MemberRepository;
import org.example.Dto.AdminDto;
import org.example.Entity.Admin;
import org.example.Entity.Member;
import org.example.unill.SessionFactoryConfiguration;
import org.hibernate.Session;

import javax.mail.MessagingException;
import java.util.Random;

public class ForgetMailServiceImpl implements ForgetMailService {

    private final MemberRepository memberRepository = (MemberRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.Member);

    private final AdminRepository adminRepository = (AdminRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.admin);
    private Session session;
    @Override
    public boolean sendEmail(String email, String user) {

        session = SessionFactoryConfiguration.getInstance().getSession();

        if (user.equals("Member")){
            memberRepository.SetSession(session);

            Member checkEmail = memberRepository.CheckEmail(email);

            if (checkEmail != null){
                //send email
                SendMail(email);
                if (ForgetPassWordFormController.user.equals("Member")){
                    LoginPageController.Admin_Username = checkEmail.getUsername();
                    return true;
                }
            }
        }

        if (user.equals("Admin")){
            adminRepository.SetSession(session);
            Admin checkEmail = adminRepository.CheckEmail(email);
            if (checkEmail != null){
                //send email
                SendMail(email);
                if (ForgetPassWordFormController.user.equals("Admin")){
                    LoginPageController.Admin_Username = checkEmail.getUsername();
                    AdminServiceImpl.data = new AdminDto(
                            checkEmail.getId(),
                            checkEmail.getName(),
                            checkEmail.getUsername(),
                            checkEmail.getPassword(),
                            checkEmail.getEmail()
                    );
                    return true;
                }
            }
        }


        return false;
    }

    void SendMail(String email){
        Random random = new Random();
        int randomValue = random.nextInt(9000) + 1000;
        ConfirmForgetPassWordFormController.otp = randomValue;
        try {
            EmailController.sendEmail(email, randomValue);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


}
