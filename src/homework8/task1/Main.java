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
        String reversePolishNotation = new String(args[0]);
        char tempCharacter;
        for (int i = 0; i < reversePolishNotation.length(); i++) {
            tempCharacter = reversePolishNotation.charAt(i);
            if(tempCharacter == '('){
                for (int j = i; j < reversePolishNotation.length(); j++) {
                    if(tempCharacter == '('){
                        break;
                    }
                    else if(tempCharacter == ')'){
                        toReversePolishNotation(reversePolishNotation.substring(i,j));
                    }
                }
            }
        }



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

/*        while (true){
            if(expression.matches("[0123456789]+\\+[0123456789]+")){

            }
        }
*/
        return expression;
        }
    }
