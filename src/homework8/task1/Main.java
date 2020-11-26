package homework8.task1;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(args[0]);
        if (!verification(args[0])) {
            System.out.println("Не верное вырожение");
            System.exit(1);
        }
        String t = toReversePolishNotation(args[0]);

        System.out.println("В обратной польской нотации выражение будет иметь вид:");
        System.out.println(t);

        System.out.println("Результат:");
        System.out.printf(reversePolishNotationToResult(t));
    }

    public static boolean verification(String expression) {
        if (expression.matches("^[0123456789()/*\\-^+ ]+$")) {
            ArrayDeque<Character> brackets = new ArrayDeque<>();

            char tempCharacter;
            for (int i = 0; i < expression.length(); i++) {
                tempCharacter = expression.charAt(i);
                if (tempCharacter == '(') {
                    brackets.add(tempCharacter);
                } else if (tempCharacter == ')') {
                    if (brackets.peekLast() != null && brackets.peekLast() == '(') {
                        brackets.removeLast();
                    } else {
                        brackets.add(tempCharacter);
                    }
                }

            }

            if (brackets.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private static String toReversePolishNotation(String expression) {
        if (expression.contains(" "))
            expression = expression.replaceAll(" ", "");
        ArrayDeque<Character> res = new ArrayDeque<>() {
            @Override
            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                for (Character character : this) {
                    stringBuilder.append(character);
                }
                return stringBuilder.toString();
            }
        };

        while (!expression.isEmpty()) {
            int i = 0;
            int j = 0;
            while (expression.contains(")")) {
                if (expression.charAt(i) == ')') {
                    j = i;
                    while (expression.charAt(j) != '(') {
                        j--;
                    }

                    String temp = toReversePolishNotation(expression.substring(j + 1, i));
                    for (int k = temp.length() - 1; k >= 0; k--) {
                        res.addFirst(temp.charAt(k));
                    }
                    temp = null;

                    StringBuffer tempStringBuffer = new StringBuffer(expression);
                    for (; i >= j; i--) {
                        tempStringBuffer.deleteCharAt(j);
                    }
                    expression = tempStringBuffer.toString();
                    i = j;
                }

                if (i >= expression.length())
                    i = 0;
                else i++;
            }
            if (expression.contains("^")) {
                expression = toReversePolishNotation(expression, '^', res);
            }
            //System.out.println(res);
            if (expression.contains("*")) {
                expression = toReversePolishNotation(expression, '*', res);
            }
            //System.out.println(res);
            if (expression.contains("/")) {
                expression = toReversePolishNotation(expression, '/', res);
            }
            //System.out.println(res);
            if (expression.contains("+")) {
                expression = toReversePolishNotation(expression, '+', res);
            }
            //System.out.println(res);
            if (expression.contains("-")) {
                expression = toReversePolishNotation(expression, '-', res);
            }
            //System.out.println(res);
            expression = "";
        }
        return res.toString();
    }

    private static String toReversePolishNotation(String expression, char fCharacter, ArrayDeque res) {
        int i = 0;
        int j;
        char character;
        while (expression.contains(Character.toString(fCharacter))) {
            character = expression.charAt(i);
            if (character == fCharacter) {
                j = i;
                StringBuilder firstValue = new StringBuilder();
                StringBuilder secondValue = new StringBuilder();
                if ((j - 1 >= 0) && Character.isDigit(expression.charAt(j - 1))) {
                    while ((j - 1 >= 0) && Character.isDigit(expression.charAt(j - 1))) {
                        j--;
                    }

                    for (int k = j; k < i; k++) {
                        firstValue.append(expression.charAt(k));
                    }
                } else firstValue = null;
                if (i + 2 <= expression.length() && Character.isDigit(expression.charAt(i + 1))) {
                    while (i + 2 <= expression.length() && Character.isDigit(expression.charAt(i + 1))) {
                        i++;
                        secondValue.append(expression.charAt(i));
                    }
                } else secondValue = null;


                StringBuffer temp = new StringBuffer(expression);
                for (; i >= j; i--) {
                    temp.deleteCharAt(j);
                }
                expression = temp.toString();
                //System.out.println(expression);

                char[] chars;
                if (firstValue == null) {
                    if (secondValue == null) {
                        res.addLast(fCharacter);
                        res.addLast(' ');
                    } else {
                        chars = secondValue.toString().toCharArray();
                        for (j = 0; j < chars.length; j++) {
                            res.addLast(chars[j]);
                        }

                        res.addLast(' ');
                        res.addLast(fCharacter);
                        res.addLast(' ');

                    }
                } else {
                    if (secondValue == null) {
                        res.addLast(fCharacter);
                        res.addLast(' ');

                        res.addFirst(' ');
                        chars = firstValue.toString().toCharArray();
                        for (j = chars.length - 1; j >= 0; j--) {
                            res.addFirst(chars[j]);
                        }
                    } else {
                        res.addFirst(' ');
                        res.addFirst(fCharacter);

                        res.addFirst(' ');
                        chars = secondValue.toString().toCharArray();
                        for (j = chars.length - 1; j >= 0; j--) {
                            res.addFirst(chars[j]);
                        }

                        res.addFirst(' ');
                        chars = firstValue.toString().toCharArray();
                        for (j = chars.length - 1; j >= 0; j--) {
                            res.addFirst(chars[j]);
                        }
                    }
                }
            }


            if ((i + 2) <= expression.length())
                i++;
            else
                break;
        }
        return expression;
    }

    private static String reversePolishNotationToResult(String reversePolishNotation) {
        ArrayList<String> listReversePolishNotation = new ArrayList<>();

        StringBuilder tempSB = new StringBuilder();
        for (int i = 0; i < reversePolishNotation.length(); i++) {
            if(reversePolishNotation.charAt(i) == ' '){
                listReversePolishNotation.add(tempSB.toString());
                tempSB = new StringBuilder();
            }
            else{
                tempSB.append(reversePolishNotation.charAt(i));
            }
        }
        int i = 2;
        while (listReversePolishNotation.size()>1){
            if(listReversePolishNotation.get(i).equals("*")){
                listReversePolishNotation.add(i+1,
                        String.valueOf(Double.parseDouble(listReversePolishNotation.get(i-2))*Double.parseDouble(listReversePolishNotation.get(i-1)))
                        );
                i = i - 2;
                for (int j = 0; j < 3; j++) {
                    listReversePolishNotation.remove(i);
                }

            }
            else if(listReversePolishNotation.get(i).equals("^")){
                listReversePolishNotation.add(i+1,
                        String.valueOf(
                                Math.pow(Double.parseDouble(listReversePolishNotation.get(i-2)),Double.parseDouble(listReversePolishNotation.get(i-1)))
                        )
                );
                i = i - 2;
                for (int j = 0; j < 3; j++) {
                    listReversePolishNotation.remove(i);
                }

            }
            else if(listReversePolishNotation.get(i).equals("/")){
                listReversePolishNotation.add(i+1,
                        String.valueOf(Double.parseDouble(listReversePolishNotation.get(i-2))/Double.parseDouble(listReversePolishNotation.get(i-1)))
                );
                i = i - 2;
                for (int j = 0; j < 3; j++) {
                    listReversePolishNotation.remove(i);
                }

            }
            else if(listReversePolishNotation.get(i).equals("+")){
                listReversePolishNotation.add(i+1,
                        String.valueOf(Double.parseDouble(listReversePolishNotation.get(i-2))+Double.parseDouble(listReversePolishNotation.get(i-1)))
                );
                i = i - 2;
                for (int j = 0; j < 3; j++) {
                    listReversePolishNotation.remove(i);
                }

            }
            else if(listReversePolishNotation.get(i).equals("-")){
                listReversePolishNotation.add(i+1,
                        String.valueOf(Double.parseDouble(listReversePolishNotation.get(i-2))-Double.parseDouble(listReversePolishNotation.get(i-1)))
                );
                i = i - 2;
                for (int j = 0; j < 3; j++) {
                    listReversePolishNotation.remove(i);
                }

            }
            i++;
        }
        return listReversePolishNotation.get(0);
    }
}
