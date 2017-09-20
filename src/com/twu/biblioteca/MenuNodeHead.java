package com.twu.biblioteca;

import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.twu.biblioteca.ConsoleIOFunc.clearTheConsoleContent;
import static com.twu.biblioteca.ConsoleIOFunc.showInfoAndReadDataFromConsole;
import static com.twu.biblioteca.ConsoleIOFunc.showInfoToConsole;

public class MenuNodeHead extends MenuNode{
    public MenuNode menuFunction(ManagerClass managerObj , UserClass user) throws IOException {
        String input;
        clearTheConsoleContent();
        this.printInfo = "\t\tWelcome\t\t\n" + this.getChildrenMenuString() + "input the option number:";
        input = showInfoAndReadDataFromConsole(this.printInfo);
        int result = this.handleInput(input);
        this.handleInputResult(result);
        return result == -1 ? this : this.childrenMenuNode.get(result - 1);
    }
    private int handleInput(String input){
        String pattern = "^(\\d+)$";
        Pattern patternObj = Pattern.compile(pattern);
        Matcher matcherObj = patternObj.matcher(input);
        if (input.length() > 0 && matcherObj.find() && matcherObj.groupCount() == 1){
                Integer handleResult = Integer.parseInt(matcherObj.group(1));
                if(handleResult > 0 && handleResult <= this.childrenMenuNode.size()) {
                    return handleResult;
                }
        }
        return -1;
    }
    private void handleInputResult(int result){
        this.printInfo = result == -1 ? "Select a valid option!\n" : "";
        showInfoToConsole(this.printInfo);
    }
}
