package homework7.task3;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static final boolean generateFirstWord = true;
    public static final boolean longMode = false;
    public static final File ruWord = new File(".\\src\\homework7\\task3\\resources\\RuWords");
    static char[] firstWordChars;
    static LinkedHashSet<String> words;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstWord = "";
        Player[] players = new Player[2];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
        }

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

        while (players[1].inGame() || players[0].inGame()) {
            for (int i = 0; i < players.length; i++) {
                while (players[i].inGame()){
                    System.out.println("ход игрока " + (i+1));
                    word = scan.nextLine().toLowerCase();
                    if (word.isBlank()){
                        players[i].setInGame(false);
                        System.out.println("счет: " + players[i].getProgress());
                    }
                    else if(!wordOfLetters(word)){
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
                        players[i].addProgress(word.length());
                        System.out.println("счет: " + players[i].getProgress());
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < players.length; i++) {
            System.out.println(String.format("Игрок %s счет: %s", i+1, players[i].getProgress()));
        }

    }

    private static boolean wordOfLetters(String word) {
        if (word.isBlank()) {
            return false;
        }
        char[] wordCharacters = word.toCharArray();
        for (int i = 0; i < wordCharacters.length; ) {
            for (int j = 0; j < firstWordChars.length; j++) {
                if (wordCharacters[i] == firstWordChars[j]) {
                    i++;
                    break;
                } else if (firstWordChars.length - 1 <= j) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isTrueWord(String word) {
        if (longMode) {
            return false;
        } else {
            return words.contains(word);
        }

    }
}
