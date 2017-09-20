package com.twu.biblioteca;

import java.io.IOException;

import static com.twu.biblioteca.ConsoleIOFunc.clearTheConsoleContent;
import static com.twu.biblioteca.ConsoleIOFunc.showInfoAndReadDataFromConsole;
import static com.twu.biblioteca.ConsoleIOFunc.showInfoToConsole;

public class MenuNodeForLogIn extends MenuNode {
    private UserManager userManager;
    private UserClass loginUser;
    MenuNodeForLogIn(){
        this.dataNeeded = "UserManager";
        this.menuNodeName = "Login in";
    }
    public MenuNode menuFunction(ManagerClass managerObj , UserClass user) throws IOException {
        String inputId;
        String inputPassword;
        int result = -1;
        this.userManager = (UserManager) managerObj;
        clearTheConsoleContent();
        while(result == -1){
            inputId = showInfoAndReadDataFromConsole("input the id number please(eg:1111111),or input q for quit:");
            if(inputId.equals("q")){
                return this.fartherMenuNode.get(0);
            }
            result = this.handleInputId(inputId);
            handleInputIdResult(result);
        }
        result = -1;
        while(result == -1){
            inputPassword = showInfoAndReadDataFromConsole("input the password please(eg:1111),or input q for quit:");
            if(inputPassword.equals("q")){
                return this.fartherMenuNode.get(0);
            }
            result = this.handleInputPassword(inputPassword);
            handleInputPasswordResult(result);
        }
        return null;
    }
    private int handleInputId(String inputId){
        if(inputId.equals("1111111")){
            return -1;
        }
        UserClass user = this.userManager.userMap.get(inputId);
        if(user != null){
            this.loginUser = user;
            return 0;
        }
        return -1;
    }
    private void handleInputIdResult(int result){
        this.printInfo = result == -1 ? "Input a valid ID please!\n" : "";
        showInfoToConsole(this.printInfo);
    }
    private int handleInputPassword(String inputPassword){
        if(this.loginUser.checkPassword(inputPassword)){
            this.userManager.activeUser = this.loginUser;
            return 0;
        }
        return -1;
    }
    private void handleInputPasswordResult(int result){
        this.printInfo = result == -1 ? "The password is not correct!\n" : "Login in success!\n";
        showInfoToConsole(this.printInfo);
    }
}
