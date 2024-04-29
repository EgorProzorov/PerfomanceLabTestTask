package org.example.task1;

public class Task1 {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        StringBuilder answ = new StringBuilder();
        int number = 1;
        do {
            answ.append(number);
            number += m - 1;
            if (number > n){
                number -= n;
            }
        } while(number != 1);

        System.out.println(answ);
    }


}
