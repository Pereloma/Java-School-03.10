package homework8.task1;

import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        System.out.println(args[0]);
        if(verification(args[0])){
            System.out.println("Не верное вырожение");
            System.exit(1);
        }



    }
    public static boolean verification(String expression){
    ArrayDeque<Character> brackets = new ArrayDeque<>();
        char tempCharacter;
        for (int i = 0; i < expression.length(); i++) {
            tempCharacter = expression.charAt(i);
            if (tempCharacter=='('){
                brackets.add(tempCharacter);
            }
            else if (tempCharacter==')' && brackets.peekLast() != null && brackets.peekLast() == '('){
                brackets.removeLast();
            }
            else if (tempCharacter==')'){
                brackets.add(tempCharacter);
            }

        }

        if(brackets.isEmpty() && expression.matches("^[0123456789()/*\\-^+ ]+$"))
            return true;
        else return false;
    }
}
