package org.example.unill;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class getIdNumber {
    public static int getIdNumber(String Type ,String Id){

        String pattern = null;

        if (Type.equals("M")){
            pattern = "M(\\d+)";
        }
        else if(Type.equals("A")){
            pattern = "A(\\d+)";
        }

        // Create a Pattern object
        Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(Id);
            if (matcher.find()) {
                String numberStr = matcher.group(1);
                int number = Integer.parseInt(numberStr);
                return number;
            }
            else {
                return 0;
            }
    }
}
