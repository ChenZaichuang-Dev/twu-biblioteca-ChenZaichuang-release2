package com.twu.biblioteca;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuNodeForQuitTest {

    @Test
    public void test() throws Exception {
        String expectReturnedMenuNode = null;
        UserClass user = new UserClass("2222222" , "2222" , "Xujun" , "1" , "2222@test.com" , "13222222222" , null);
        UserManager userManager = new UserManager();
        MenuNodeForQuit menuNodeForQuit = new MenuNodeForQuit();
        assertEquals(expectReturnedMenuNode , menuNodeForQuit.menuFunction(userManager , user));
    }
}
