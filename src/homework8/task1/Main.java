package homework8.task1;

import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        System.out.println(args[0]);
        if (!verification(args[0])) {
            System.out.println("Не верное вырожение");
            System.exit(1);
        }

        System.out.println("В обратной польской нотации выражение будет иметь вид:");
        System.out.printf(toReversePolishNotation(args[0]));




        //Результат:
        }
        public static boolean verification (String expression){
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

        private static String toReversePolishNotation (String expression){
        expression = expression.replaceAll(" ","");
        ArrayDeque<Character> res = new ArrayDeque<>(){
            @Override
            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                for (Character character: this){
                    stringBuilder.append(character);
                }
                return stringBuilder.toString();
            }
        };

        while (!expression.isEmpty()){
            if(expression.contains("^")){
                toReversePolishNotation(expression,'^',res);
            }
            expression = "";
        }
        return res.toString();
        }

    private static void toReversePolishNotation (String expression, char fCharacter, ArrayDeque res){
        int i = 0;
        int j;
        char character;
        while (expression.contains(Character.toString(fCharacter))){
            character = expression.charAt(i);
            if(character == fCharacter){
                j=i;
                while ((j-1 >= 0) && Character.isDigit(expression.charAt(j-1)))
                    j--;
                i++;
                while (i+2 <= expression.length() && Character.isDigit(expression.charAt(i+1)))
                    i++;

                if(Character.isDigit(expression.charAt(j))){
                    for (; j <= i; i--) {
                        if (!Character.isDigit(expression.charAt(j))){

                        }
                        else {
                            res
                        }
                    }
                }
            }

            if((i+2) <= expression.length())
                i++;
            else
                break;
        }
    }
}
