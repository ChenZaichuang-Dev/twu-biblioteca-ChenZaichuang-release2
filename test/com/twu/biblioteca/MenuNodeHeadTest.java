package com.twu.biblioteca;

import org.junit.*;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class MenuNodeHeadTest {
    @Test
    public void menuFunctionTest() throws IOException {
        PrintStream console = System.out;
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bytes));
        InputStream keyBoard = System.in;

        UserManager userManager = new UserManager();
        UserClass user;

        String expectPrintString =  "\t\tWelcome\t\t\n" + "1.Login in\n" + "2.List Books\n" +
                "3.List Movies\n" + "4.Quit\n" + "input the option number:";
        System.setIn(new FileInputStream("resource/inputOptionNumber4.txt"));
        user = userManager.userMap.get("1111111");
        user.menuNodeManager.runMenu();
        assertEquals(expectPrintString, bytes.toString());

        expectPrintString +=  "\t\tWelcome\t\t\n" + "1.List Books\n" + "2.Check Out Books\n" +
                "3.Return Books\n" + "4.List Movies\n" + "5.Check Out Movies\n" +
                "6.Show User Information\n" + "7.Login out\n" + "8.Quit\n" + "input the option number:";
        System.setIn(new FileInputStream("resource/inputOptionNumber8.txt"));
        user = userManager.userMap.get("2222222");
        user.menuNodeManager.runMenu();
        assertEquals(expectPrintString, bytes.toString());

        expectPrintString +=  "\t\tWelcome\t\t\n" + "1.List Books\n" + "2.List Checked Out Books\n" +
                "3.Check Out Books\n" + "4.Return Books\n" + "5.List Movies\n" +
                "6.Check Out Movies\n" + "7.Login out\n" + "8.Quit\n" + "input the option number:";
        System.setIn(new FileInputStream("resource/inputOptionNumber8.txt"));
        user = userManager.userMap.get("3333333");
        user.menuNodeManager.runMenu();
        assertEquals(expectPrintString, bytes.toString());

        System.setOut(console);
        System.setIn(keyBoard);
    }
}
