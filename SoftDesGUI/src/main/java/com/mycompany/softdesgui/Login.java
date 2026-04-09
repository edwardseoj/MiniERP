package com.mycompany.softdesgui;

public class Login {
    //  hardcoded for now
    private static final String adminUser = "Admin";
    private static final String adminPass = "1234";
    private static final String empUser = "Employee";
    private static final String empPass = "67";

    public static boolean isValidCredential(String user, String pass){
        if((user.equals("Admin") || user.equals("Employee")) && (pass.equals("1234") || pass.equals("67"))){
            System.out.println("Login successful");
            return true;
        } else{
            System.out.println("Invalid Credentials");
        }
        return false;
    }
    public void changeScreen(String user, String pass){
        if(!isValidCredential(user, pass)){
            return;
        }

        // continue this later

    }
}
