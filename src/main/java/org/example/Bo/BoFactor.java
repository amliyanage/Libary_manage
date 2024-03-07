package org.example.Bo;

import org.example.Bo.Custom.AdminBoImpl;
import org.example.Bo.Custom.MemberBoImpl;

public class BoFactor {

    private static BoFactor boFactor;
    private BoFactor(){

    }

    public static BoFactor getBoFactory(){
        return (boFactor == null) ? boFactor = new BoFactor() : boFactor;
    }

    public enum BoType{
        Member,Admin
    }

    public SuperBo getBo(BoType boType){
        switch (boType){
            case Member :
                return new MemberBoImpl();
            case Admin:
                return new AdminBoImpl();
            default:
                return null;
        }
    }
}
