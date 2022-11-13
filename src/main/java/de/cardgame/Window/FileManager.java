package de.cardgame.Window;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;

public class FileManager {
    private static String IMG_DIR = "";
    private static String CARD_DIR = "";
    private static String DICE_DIR = "";
    private static String HEALTH_DIR = "";
    private static String GOLD_DIR = "";
    private static String SOULS_DIR = "";

    private static LinkedList<String> unRotate;
    private static boolean noFlip;

    public static boolean findDirectory(String dir) {
        return Files.exists(Path.of(dir));
    }

    public static boolean findFile(String path) {
        return Files.isRegularFile(Path.of(path));
    }

    public static boolean setDir(String... dirs) {
        if (!findDirs(dirs[0], dirs[1], dirs[2], dirs[3], dirs[4], dirs[5])) {
            System.err.println("Folder doesnt exist or doesnt include required Folders.");
            return false;
        }
        IMG_DIR = dirs[0];
        CARD_DIR = getImgDir() + "/" + dirs[1];
        DICE_DIR = getImgDir() + "/" + dirs[2];
        HEALTH_DIR = getImgDir() + "/" + dirs[3];
        GOLD_DIR = getImgDir() + "/" + dirs[4];
        SOULS_DIR = getImgDir() + "/" + dirs[5];
        return true;
    }

    private static boolean findDirs(String... dirs) {
        for (int i = 1; i < dirs.length; i++) {
            String d = dirs[i];
            System.out.println(dirs[0] + "/" + d);
            if (!findDirectory(dirs[0] + "/" + d)) {
                System.err.println("Directory " + dirs[0] + "/" + d + " not found.");
                return false;
            }
        }
        return true;
    }

    public static boolean exist() {
        return findDirectory(getImgDir()) &&
                findDirectory(getCardDir()) &&
                findDirectory(getDiceDir()) &&
                findDirectory(getHealthDir()) &&
                findDirectory(getGoldDir()) &&
                findDirectory(getSoulsDir());
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

    public static String getGoldDir() {
        return GOLD_DIR;
    }

    public static String getSoulsDir() {
        return SOULS_DIR;
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
