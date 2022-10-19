package de.cardgame;

import de.cardgame.Window.MainKeyListener;
import de.cardgame.Window.MainWindowHandler;
import de.cardgame.Window.MouseWindowHandler;
import de.cardgame.Window.Window;

public class Main {
    private static Window mainWindow;
    private static MainWindowHandler mainWindowHandler;
    private static MouseWindowHandler mouseWindowHandler;
    private static MainKeyListener mainKeyListener;

    public static void main(String[] args) {
        //Set Table
        FileManager.setImagesDir("./Textures");
        Table playground = new Table();

        //Set Frame
        mainWindowHandler = new MainWindowHandler();
        mainKeyListener = new MainKeyListener();
        mainWindow = new Window(playground);
        mouseWindowHandler= new MouseWindowHandler(playground, mainWindow);
        mainKeyListener.setWindow(mainWindow);
        mainWindow.setMouseListener(mouseWindowHandler);
        mainWindow.setHandler(mainWindowHandler);
        mainWindow.setKeyListener(mainKeyListener);
    }
}
