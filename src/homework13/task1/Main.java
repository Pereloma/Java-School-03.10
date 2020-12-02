package homework13.task1;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File(args[0]);
        if (!file.isDirectory()) {
            System.exit(0);
        }
        printTree(file);
    }

    public static void printTree(File dir){
        StringBuilder prefix = new StringBuilder();
        printTree(dir,prefix);
    }

    private static void printTree(File dir,StringBuilder prefix){
        File[] files = dir.listFiles();
        if(files != null && files.length !=0) {
            for (int i = 0; i < files.length - 1; i++) {
                System.out.print(prefix.toString());
                System.out.print("╟─");
                System.out.println(files[i].getName());

                if(files[i].isDirectory()){
                    printTree(files[i],prefix.append("║ "));
                }
            }
            System.out.print(prefix.toString());
            System.out.print("╙─");
            System.out.println(files[files.length - 1].getName());

            if(files[files.length - 1].isDirectory()){
                printTree(files[files.length - 1],prefix.append("  "));
            }

        }
        if(prefix.length() >= 2)
            prefix.setLength(prefix.length()-2);
    }


/*
    private static void printTree(int level, File dir) {
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        });
        File[] dirs = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });

        if (files == null || files.length == 0) {
            if (dirs != null && dirs.length != 0) {
                for (int i = 0; i < dirs.length - 1; i++) {
                    print(level, "╟─", dirs[i].getName());
                    printTree(level + 1, dirs[i]);
                }
                print(level, "╙─", dirs[dirs.length - 1].getName());
                printTree(level + 1, dirs[dirs.length - 1]);
            }
        } else if (dirs != null && dirs.length != 0) {
            for (int i = 0; i < dirs.length; i++) {
                print(level, "╟─", dirs[i].getName());
                printTree(level + 1, dirs[i]);
            }
            for (int i = 0; i < files.length - 1; i++) {
                print(level, "╟─", files[i].getName());
            }
            print(level, "╙─", files[files.length - 1].getName());
        }
    }

    private static void printTree(File dir) {
        List<Boolean> fileIsEnd = new LinkedList<>();
        System.out.println(dir.getAbsolutePath());
        printTree(0, dir);
    }


    public static void print(int indent, String symbol, String str) {
        for (int i = 0; i < indent; i++) {
            System.out.print("║ ");
        }
        System.out.print(symbol);
        System.out.println(str);
    }
    */
}
