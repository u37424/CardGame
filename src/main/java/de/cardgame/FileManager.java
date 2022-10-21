package de.cardgame;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
    private static String IMG_DIR = "";
    private static String CARD_DIR = "";
    private static String DICE_DIR = "";

    public static boolean findDirectory(String dir) {
        if (Files.exists(Path.of(dir))) return true;
        else return false;
    }

    public static boolean findFile(String path) {
        if (Files.isRegularFile(Path.of(path))) return true;
        else return false;
    }

    public static String getImgDir() {
        return IMG_DIR;
    }

    public static void setImagesDir(String imgDir, String cardFolderName, String diceFolderName) {
        if (findDirectory(imgDir) && findDirectory(imgDir + "/" + cardFolderName) && findDirectory(imgDir + "/" + diceFolderName)) {
            IMG_DIR = imgDir;
            CARD_DIR = imgDir + "/" + cardFolderName;
            DICE_DIR = imgDir + "/" + diceFolderName;
        } else System.err.println("Folder doesnt exist or doesnt include required Folders.");
    }

    public static String getCardDir() {
        return CARD_DIR;
    }

    public static String getDiceDir() {
        return DICE_DIR;
    }
}
