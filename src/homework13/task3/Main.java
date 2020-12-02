package homework13.task3;

import java.io.*;

public class Main {
    static boolean
            bytes = false,
            count = false,
            lines = false,
            words = false;
    public static void main(String[] args) {
        for (int i = 1; i < args.length; i++) {
            if (args[i].toLowerCase().equals("-c")||args[i].toLowerCase().equals("-bytes"))
                bytes = true;
            else if (args[i].toLowerCase().equals("-m")||args[i].toLowerCase().equals("-count"))
                count = true;
            else if (args[i].toLowerCase().equals("-l")||args[i].toLowerCase().equals("-lines"))
                lines = true;
            else if (args[i].toLowerCase().equals("-w")||args[i].toLowerCase().equals("-words"))
                words = true;
        }

        System.out.println("bytes - " + bytes);
        System.out.println("count - " + count);
        System.out.println("lines - " + lines);
        System.out.println("words - " + words);

        File file = new File(args[0]);
        StringBuilder result = new StringBuilder();

        try {
            if(!bytes && !count && !lines && !words){
                bytes = true;
                count = true;
                lines = true;
                words = true;
            }
            if(bytes){
                result.append(getBytes(file));
                result.append("    ");
            }
            if(count){
                result.append(getCount(file));
                result.append("    ");
            }
            if(lines){
                result.append(getLines(file));
                result.append("    ");
            }
            if(words){
                result.append(getWords(file));
                result.append("    ");
            }
            result.setLength(result.length() - 4);
            System.out.println();
            System.out.println(result.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static long getBytes (File file) throws FileNotFoundException {

        return file.length();
    }


    public static long getCount (BufferedReader bufferedReader) throws IOException{
        long res = 0;
        while (bufferedReader.ready()) {
            res += bufferedReader.readLine().length();
        }
        return res;
    }

    public static long getCount (File file) throws IOException{
        long res = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (bufferedReader.ready()) {
                res += bufferedReader.readLine().length();
            }
            return res;
        }
    }


    public static long getLines (BufferedReader bufferedReader) throws IOException {
        long res = 0;
        while (bufferedReader.ready()) {
            bufferedReader.skip(1);
            res++;
        }
        return res;
    }

    public static long getLines (File file) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            long res = 0;
            while (bufferedReader.ready()) {
                bufferedReader.skip(1);
                res++;
            }
            return res;
        }
    }


    public static long getWords (BufferedReader bufferedReader) throws IOException {
        long res = 0;
        while (bufferedReader.ready()) {
            res += bufferedReader.readLine().replaceAll("( )+", " ").trim().split(" ").length;
        }
        return res;
    }

    public static long getWords (File file) throws IOException {
        long res = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (bufferedReader.ready()) {
                res += bufferedReader.readLine().replaceAll("( )+", " ").trim().split(" ").length;
            }
            return res;
        }
    }
}
