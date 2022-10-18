package de.cardgame;

public class Main {
    private static Window mainWindow;
    private static MainWindowHandler mainWindowHandler;
    private static MouseWindowHandler mouseWindowHandler;
    private static MainKeyListener mainKeyListener;

    public static void main(String[] args) {
        //Set Table
        FileManager.setCardImagesDir("./Cards");
        Table playground = new Table();

        //Set Frame
        mainWindowHandler = new MainWindowHandler();
        mouseWindowHandler= new MouseWindowHandler();
        mainKeyListener = new MainKeyListener();
        mainWindow = new Window(playground);
        mainKeyListener.setWindow(mainWindow);
        mainWindow.setMouseListener(mouseWindowHandler);
        mainWindow.setHandler(mainWindowHandler);
        mainWindow.setKeyListener(mainKeyListener);
    }
}
