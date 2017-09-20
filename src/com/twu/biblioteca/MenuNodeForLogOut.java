package com.twu.biblioteca;

import java.io.IOException;
import java.util.Map;

public class MenuNodeForLogOut extends MenuNode{
    private UserManager userManager;
    MenuNodeForLogOut(){
        this.dataNeeded = "UserManager";
        this.menuNodeName = "Login out";
    }
    public MenuNode menuFunction(ManagerClass managerObj , UserClass user) throws IOException {
        this.userManager = (UserManager) managerObj;
        this.userManager.activeUser = this.userManager.userMap.get("1111111");
        return null;
    }
}
