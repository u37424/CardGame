package de.cardgame.Window;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;

public class FileManager {
    private static String IMG_DIR = "";
    private static String CARD_DIR = "";
    private static String DICE_DIR = "";
    private static String HEALTH_DIR = "";
    private static LinkedList<String> unRotate;
    private static boolean noFlip;

    public static boolean findDirectory(String dir) {
        return Files.exists(Path.of(dir));
    }

    public static boolean findFile(String path) {
        return Files.isRegularFile(Path.of(path));
    }

    public static boolean setDir(String imgDir, String cards, String dice, String health) {
        if (!findDirs(imgDir, cards, dice, health)) {
            System.err.println("Folder doesnt exist or doesnt include required Folders.");
            return false;
        }
        IMG_DIR = imgDir;
        CARD_DIR = imgDir + "/" + cards;
        DICE_DIR = imgDir + "/" + dice;
        HEALTH_DIR = imgDir + "/" + health;
        return true;
    }

    private static boolean findDirs(String imgDir, String cards, String dice, String health) {
        return findDirectory(imgDir) &&
                findDirectory(imgDir + "/" + cards) &&
                findDirectory(imgDir + "/" + dice) &&
                findDirectory(imgDir + "/" + health);
    }

    public static boolean exist() {
        return findDirectory(getImgDir()) &&
                findDirectory(getCardDir()) &&
                findDirectory(getDiceDir()) &&
                findDirectory(getHealthDir());
    }

    public static String getImgDir() {
        return IMG_DIR;
    }

    public static String getCardDir() {
        return CARD_DIR;
    }

    public static String getDiceDir() {
        return DICE_DIR;
    }

    public static String getHealthDir() {
        return HEALTH_DIR;
    }

    public static void setUnRotate(LinkedList<String> unRotate) {
        FileManager.unRotate = unRotate;
    }

    public static boolean isUnRotated(String card) {
        for (String c : unRotate) {
            if (c.equals(card)) return true;
        }
        return false;
    }

    public static void setNoFlip(boolean b) {
        FileManager.noFlip = b;
    }

    public static boolean isNoFlip() {
        return noFlip;
    }
}
