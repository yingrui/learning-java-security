package me.yingrui.learning.java.security;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileSecurityPolicy {

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length > 0 && args[0].equals("--help")) {
            pringUsage();
            return;
        }
        //Is there a SecurityManger registered?
        System.out.println("SecurityManager: " + System.getSecurityManager());

        //Checking if we can open a file for reading
        FileInputStream fis = new FileInputStream("test.txt");
        System.out.println("File successfully opened");

        //Checking if we can access a vm property
        System.out.println(System.getProperty("file.encoding"));
    }

    private static void pringUsage() {
        System.out.println("java -Djava.security.manager -Djava.security.policy=<<policy file>> -cp <<jar file>> " + FileSecurityPolicy.class.getName());
        System.out.println("policy file example:");
        System.out.println("grant {\n" +
                "  permission java.io.FilePermission \"test.txt\", \"read\";\n" +
                "  permission java.util.PropertyPermission \"file.encoding\", \"read\";\n" +
                "};");
    }
}
