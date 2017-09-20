package com.twu.biblioteca;

import java.io.IOException;

import static com.twu.biblioteca.ConsoleIOFunc.generateSpecificLengthOfString;
import static com.twu.biblioteca.ConsoleIOFunc.showInfoToConsole;

public class MenuNodeForShowUserInfo extends MenuNode{
    MenuNodeForShowUserInfo(){
        this.dataNeeded = "BookManager";
        this.menuNodeName = "Show User Information";
    }
    public MenuNode menuFunction(ManagerClass managerObj , UserClass user) throws IOException {
        printUserInfo(30 , user);
        return this.fartherMenuNode.get(0);
    }
    private void printUserInfo(int contentLength , UserClass user){
        String userInfoString =  generateSpecificLengthOfString(contentLength , "id") +
                generateSpecificLengthOfString(contentLength , "name") +
                generateSpecificLengthOfString(contentLength , "permissionLevel") +
                generateSpecificLengthOfString(contentLength , "emailAddress") +
                generateSpecificLengthOfString(contentLength , "phoneNumber") + "\n" +
                user.generateUserInfoString(contentLength) + "\n";
        showInfoToConsole(userInfoString);
    }
}
