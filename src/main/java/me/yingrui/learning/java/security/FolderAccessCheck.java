package me.yingrui.learning.java.security;

import java.io.FilePermission;
import java.security.AccessController;

public class FolderAccessCheck {

    public static void main(String[] args) {
        try {
            // A pathname that ends in "/*" (where "/" is the file separator character, File.separatorChar)
            // indicates all the files and directories contained in that directory.
            // A pathname that ends with "/-" indicates (recursively) all files and subdirectories contained in that directory.
            // The special pathname "<<ALL FILES>>" matches any file.

            // A pathname consisting of a single "*" indicates all the files in the current directory,
            // while a pathname consisting of a single "-" indicates all the files in the current directory
            // and (recursively) all files and subdirectories contained in the current directory.
            AccessController.checkPermission(new FilePermission("/tmp/-", "read,write"));
            System.out.println("You have read and write permission for /tmp");
        } catch (SecurityException e) {
            // Does not have permission
            e.printStackTrace();
        }

    }
}
