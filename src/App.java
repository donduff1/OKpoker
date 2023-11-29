/*
* File: App.java
* Author: Decker Borisz
* Copyright: 2023, Decker Borisz
* Date: 2023-11-29
* Licenc: MIT
*
*/

import controllers.MainController;
import views.MainWindow;

public class App {
    public static void main(String[] args)
            throws Exception {
        MainWindow mainWindow = new MainWindow();
        new MainController(mainWindow);
        mainWindow.setVisible(true);
    }
}
