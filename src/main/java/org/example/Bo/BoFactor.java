package org.example.Bo;

import org.example.Bo.Custom.AdminBoImpl;
import org.example.Bo.Custom.MemberBoImpl;
import org.example.Bo.Custom.SearchBookBoImpl;

public class BoFactor {

    private static BoFactor boFactor;
    private BoFactor(){

    }

    public static BoFactor getBoFactory(){
        return (boFactor == null) ? boFactor = new BoFactor() : boFactor;
    }

    public enum BoType{
        Member,Admin,Search_Book
    }

    public SuperBo getBo(BoType boType){
        switch (boType){
            case Member :
                return new MemberBoImpl();
            case Admin:
                return new AdminBoImpl();
            case Search_Book:
                return new SearchBookBoImpl();
            default:
                return null;
        }
    }
}
