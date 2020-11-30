package homework13.task2;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        File file = new File(args[0]);

        try(
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                )
        {
            String temp;
            Pattern pattern = Pattern.compile(args[1]);
            while (bufferedReader.ready()){
                temp = bufferedReader.readLine();
                if(pattern.matcher(temp).find()){
                    System.out.println(temp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
