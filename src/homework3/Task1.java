package homework3;

public class Task1 {
    /*
    1. (с помощью рекурсии) Написать функцию, которая проверяет, является ли слово палиндромом.
    Палиндром - это слово, читающееся в обоих направлениях одинаково. Например, "топот", "доход".
    Для получения символа из строки используйте:

    String a = "топот";
    var symbol = a.charAt(0); // первая буква
    */
    public static void main(String[] args) {
        String a = "топот";
        //var symbol = a.charAt(0);

        System.out.println(palindrome(0,a));
    }

    public static boolean palindrome (int n,String text){
        if(text.charAt(n) == text.charAt(text.length()-n-1)){
            if(n == text.length()/2)
                return true;
            else
                return palindrome(n+1,text);
        }else return false;
    }
}
