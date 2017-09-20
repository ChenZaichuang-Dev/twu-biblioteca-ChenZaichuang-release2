package com.twu.biblioteca;

import java.io.IOException;

public class BibliotecaApp {
    public static void main(String[] args) throws IOException {
        UserManager userManager = new UserManager();
        userManager.startAppWithIdentification();
    }
}
