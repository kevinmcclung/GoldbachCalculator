package com.sonnysappbakery;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Enter even integer from 4 to 2147483646.");
            int num = 0;
            try {
                num = scanner.nextInt();
            } catch(Exception e) {
                System.err.println("Unexpected error. Terminating program.");
                scanner.close();
                break;
            }
            goldbach(num);
        }
    }

    //Returns true if number is prime.
    static boolean isPrime(int num) {
        if(num < 2) return false;
        if(num == 2 || num == 3) return true;
        for(int i = 2; i <= num / 2; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    //Verifies Goldbach's Conjecture for any even integer from 4 to 2147483646.
    //Returns true if the number is the sum of two prime numbers.
    static boolean goldbach(int num) {
        if(num <= 2) num = 4;
        else if(num %2 != 0) num++;
        for(int i = 2; i <= num - 2; i++) {
            if(isPrime(i)) {
                int dif = num - i;
                if(isPrime(dif)) {
                    System.out.println(num + " is the sum of " + i + " and " + dif + ", both prime numbers.");
                    System.out.println("Nice try, but Goldbach's Conjecture is still true!");
                    return true;
                }
            }
        }
        System.out.println("CONGRATULATIONS, " + num + "IS NOT THE SUM OF ANY TWO PRIME NUMBERS. YOU HAVE DISPROVED GOLDBACH'S CONJECTURE!");
        return false;
    }
}
