package homework13.task1;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        File file = new File(args[0]);
        if(!file.isDirectory()){
            System.exit(0);
        }
        printTree(file);
//        for (File file1 : file.listFiles()){
//            System.out.println(file1.getAbsolutePath());
//        }
    }
    private static void printTree(int level,File dir){
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

        if(files == null || files.length == 0){
            if(dirs != null && dirs.length != 0) {
                for (int i = 0; i < dirs.length-1; i++) {
                    print(level,"╟─",dirs[i].getName());
                    printTree(level+1,dirs[i]);
                }
                print(level,"╙─",dirs[dirs.length-1].getName());
                printTree(level+1,dirs[dirs.length-1]);
            }
        }
        else if(dirs != null && dirs.length != 0) {
            for (int i = 0; i < dirs.length; i++) {
                print(level,"╟─",dirs[i].getName());
                printTree(level+1,dirs[i]);
            }
            for (int i = 0; i < files.length-1; i++) {
                print(level,"╟─",files[i].getName());
            }
            print(level,"╙─",files[files.length-1].getName());
        }
    }
    private static void printTree(File dir){
        System.out.println(dir.getAbsolutePath());
        printTree(0,dir);
    }



    public static void print(int indent, String symbol, String str){
        if(indent>0)
            System.out.print("║");
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }
        System.out.print(symbol);
        System.out.println(str);
    }
}
