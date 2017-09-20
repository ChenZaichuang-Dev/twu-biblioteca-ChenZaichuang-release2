package com.twu.biblioteca;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserManager extends ManagerClass{
    public Map<String , UserClass> userMap = new HashMap<String , UserClass>();
    public UserClass activeUser;
    UserManager(){
        UserClass user = new UserClass("1111111" , "1111" , "ChenZaichuang" , "0" , "1111@test.com" , "13111111111" , this);
        this.userMap.put("1111111" , user);
        user = new UserClass("2222222" , "2222" , "Xujun" , "1" , "2222@test.com" , "13222222222" , this);
        this.userMap.put("2222222" , user);
        user = new UserClass("3333333" , "3333" , "Tanpeng" , "2" , "3333@test.com" , "13333333333" , this);
        this.userMap.put("3333333" , user);
        this.activeUser = this.userMap.get("1111111");
    }
    public void startAppWithIdentification() throws IOException {
        while(this.activeUser != null){
            this.activeUser.menuNodeManager.runMenu();
        }
    }
}
