package org.example.Bo;

import org.example.Bo.Custom.*;

public class ServiceFactor {

    private static ServiceFactor serviceFactor;
    private ServiceFactor(){

    }

    public static ServiceFactor getBoFactory(){
        return (serviceFactor == null) ? serviceFactor = new ServiceFactor() : serviceFactor;
    }

    public enum BoType{
        Member,Admin,Search_Book,Register,Manage_Book,UserMange,Branch,DashBoard,MemberDashBoard,Admin_Register
    }

    public SuperService getBo(BoType boType){
        switch (boType){
            case Member :
                return new MemberServiceImpl();
            case Admin:
                return new AdminServiceImpl();
            case Search_Book:
                return new SearchBookServiceImpl();
            case Register:
                return new RegisterServiceImpl();
            case Manage_Book:
                return new ManageBookServiceImpl();
            case UserMange:
                return new UserManageServiceImpl();
            case Branch:
                return new BranchServiceImpl();
            case DashBoard:
                return new DashboardServiceImpl();
            case MemberDashBoard:
                return new MemberDashboardServerImpl();
            case Admin_Register:
                return new AdminRegisterServiceImpl();
            default:
                return null;
        }
    }
}
