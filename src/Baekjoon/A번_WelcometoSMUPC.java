package Baekjoon;

import java.util.Scanner;

public class A번_WelcometoSMUPC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        StringBuffer s = new StringBuffer("WelcomeToSMUPC");

        while (e>s.length()){
            s.append("WelcomeToSMUPC");
        }
        char index = (char) (s.charAt(e-1));
        System.out.println(index);
    }
}
