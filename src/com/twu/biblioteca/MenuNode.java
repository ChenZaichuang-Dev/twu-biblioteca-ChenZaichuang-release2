package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuNode {
    String printInfo;
    String dataNeeded = "";
    String menuNodeName = "";
    List<MenuNode> fartherMenuNode = new ArrayList<>();
    List<MenuNode> childrenMenuNode = new ArrayList<>();
    String getChildrenMenuString(){
        String menuInfo = "";
        for(Integer index = 1; index <= this.childrenMenuNode.size(); index++){
            menuInfo += index.toString() + "." + this.childrenMenuNode.get(index - 1).menuNodeName + "\n";
        }
        return menuInfo;
    }
    void setMyFarther(MenuNode fartherNode){
        fartherMenuNode.add(fartherNode);
    }
    void setMyChild(MenuNode childNode){
        childrenMenuNode.add(childNode);
    }
    public MenuNode menuFunction(ManagerClass managerObj , UserClass user) throws IOException {
        return null;
    }
}
