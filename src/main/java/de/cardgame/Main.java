package de.cardgame;

import de.cardgame.Window.*;

public class Main {
    private static Window mainWindow;
    private static MainWindowHandler mainWindowHandler;
    private static MouseWindowHandler mouseWindowHandler;
    private static MainKeyListener mainKeyListener;

    public static void main(String[] args) {
        //Set Table
        if(!FileManager.setDir("./Textures", "Cards_STD", "Dice_STD", "Health_STD")) return;
        FileManager.setNoFlip(false);

        //Set Frame
        mainWindowHandler = new MainWindowHandler();
        mainKeyListener = new MainKeyListener();
        mainWindow = new Window();
        mouseWindowHandler= new MouseWindowHandler(mainWindow);
        mainKeyListener.setWindow(mainWindow);
        mainWindow.setMouseListener(mouseWindowHandler);
        mainWindow.setHandler(mainWindowHandler);
        mainWindow.setKeyListener(mainKeyListener);
    }
}
