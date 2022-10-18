package de.cardgame;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
    private static String CARD_IMG_DIR = "";

    public static boolean findDirectory(String dir) {
        if (Files.exists(Path.of(dir))) return true;
        else return false;
    }

    public static String getCardImgDir() {
        return CARD_IMG_DIR;
    }

    public static void setCardImagesDir(String pngDir) {
        if(findDirectory(pngDir)) CARD_IMG_DIR = pngDir;
        else System.err.println("Cannot set Card Folder.");
    }

    public static boolean findFile(String path) {
        if (Files.isRegularFile(Path.of(path))) return true;
        else return false;
    }
}
