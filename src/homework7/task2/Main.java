package homework7.task2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static final boolean generateFirstWord = true;
    public static final boolean longMode = false;
    public static final File ruWord = new File(".\\src\\homework7\\task2\\resources\\RuWords");
    static char[] firstWordChars;
    static LinkedHashSet<String> words;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstWord = "";
        long progress = 0;

        Set<String> usedWords = new HashSet<>();

        if (generateFirstWord) {
            if (longMode) {
                try (BufferedReader br = new BufferedReader(new FileReader(ruWord))) {
                    while (br.ready()) {
                        words.add(br.readLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                words = new LinkedHashSet<>();
                try (BufferedReader br = new BufferedReader(new FileReader(ruWord))) {
                    while (br.ready()) {
                        words.add(br.readLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int intTemp = (int) (Math.random() * words.size());
                for (String stringI : words) {
                    if (intTemp == 0) {
                        firstWord = stringI;
                        break;
                    } else {
                        intTemp--;
                    }
                }

            }
        } else {
            System.out.println("Веедите первое слово");
            firstWord.toLowerCase();
            firstWord = scan.nextLine();
        }
        firstWordChars = firstWord.toCharArray();

        System.out.print("Первое слово: ");
        System.out.println(firstWord);

        String word;
        while (!(word = scan.nextLine().toLowerCase()).isBlank()) {
            if(!wordOfLetters(word)){
                System.out.println("Не из букв первого слова");
            }
            else if (usedWords.contains(word)){
                System.out.println("Слово уже было");
            }
            else if(!isTrueWord(word)){
                System.out.println("Такого слова нет");
            }
            else {
                usedWords.add(word);
                progress += word.length();
                System.out.println("счет: " + progress);
            }
        }
        System.out.println("Гамовер");
        System.out.println("счет: " + progress);


    }

    private static boolean wordOfLetters(String word) {
        if(word.isBlank()){
            return false;
        }
        char[] wordCharacters = word.toCharArray();
        for (int i = 0; i < wordCharacters.length;) {
            for (int j = 0; j < firstWordChars.length; j++) {
                if(wordCharacters[i] == firstWordChars[j]){
                    i++;
                    break;
                }
                else if(firstWordChars.length-1<=j){
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isTrueWord(String word){
        if(longMode){
            return false;
        }else {
            return words.contains(word);
        }

    }
}
