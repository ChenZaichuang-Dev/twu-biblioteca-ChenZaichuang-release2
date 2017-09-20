package com.twu.biblioteca;

import java.io.IOException;
import java.util.Map;

public class MenuNodeForQuit extends MenuNode{
    private UserManager userManager;
    MenuNodeForQuit(){
        this.dataNeeded = "UserManager";
        this.menuNodeName = "Quit";
    }
    public MenuNode menuFunction(ManagerClass managerObj , UserClass user) throws IOException {
        this.userManager = (UserManager) managerObj;
        this.userManager.activeUser = null;
        return null;
    }
}
