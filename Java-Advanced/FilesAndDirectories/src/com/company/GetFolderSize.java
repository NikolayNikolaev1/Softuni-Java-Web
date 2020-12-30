package com.company;

import java.io.File;

public class GetFolderSize {
    private static final String FOLDER_PATH = "Resources/Exercises Resources";

    public static void main(String[] args) {
        File file = new File(FOLDER_PATH);
        System.out.println(getDirectorySizeLegacy(file));
    }

    // Using method so it can be called back inside it.
    public static long getDirectorySizeLegacy(File dir) {
        long length = 0;
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile())
                    length += file.length();
                else
                    length += getDirectorySizeLegacy(file);
            }
        }

        return length;
    }
}
