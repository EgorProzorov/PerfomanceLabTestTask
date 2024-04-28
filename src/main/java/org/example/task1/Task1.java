package org.example.task1;


import java.util.Scanner;

public class Task1 {
    public static void main(String[] args){
        if(args.length < 2){
            return;
        }
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        String answ = "";
        int number = 1;
        do {
            answ += number;
            number += m - 1;
            if (number > n){
                number -= n;
            }
        } while(number != 1);

        System.out.println(answ);
    }


}
