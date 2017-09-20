package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

import static com.twu.biblioteca.ConsoleIOFunc.generateSpecificLengthOfString;

public class UserClass {
    public Map<String , String>userInfo = new HashMap<>();
    public MenuNodeManager menuNodeManager;
    public UserManager userManager;
    UserClass(String id , String password , String name , String permissionLevel , String emailAddress , String phoneNumber , UserManager userManager){
        this.userInfo.put("id" , id);
        this.userInfo.put("password" , password);
        this.userInfo.put("name" , name);
        this.userInfo.put("permissionLevel" , permissionLevel);
        this.userInfo.put("emailAddress" , emailAddress);
        this.userInfo.put("phoneNumber" , phoneNumber);
        this.userManager = userManager;
        this.menuNodeManager = new MenuNodeManager(this.userManager , this);
    }
    public static boolean checkIfTwoUsersAreSame(UserClass user1 , UserClass user2){
        return  user1.userInfo.get("id").equals(user2.userInfo.get("id"));
    }
    public boolean checkPassword(String password){
        return this.userInfo.get("password").equals(password);
    }
    public String generateUserInfoString(int contentLength){
        return generateSpecificLengthOfString(contentLength , this.userInfo.get("id")) +
                generateSpecificLengthOfString(contentLength , this.userInfo.get("name")) +
                generateSpecificLengthOfString(contentLength , this.userInfo.get("permissionLevel")) +
                generateSpecificLengthOfString(contentLength , this.userInfo.get("emailAddress")) +
                generateSpecificLengthOfString(contentLength , this.userInfo.get("phoneNumber")) + "\n";
    }
}
