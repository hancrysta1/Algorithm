package Baekjoon;

import java.util.Scanner;

public class B번_우당탕탕영화예매 {
    static int count=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int people = sc.nextInt();
        String movie[] = new String[N];

        for (int i=0;i<N;i++){
            StringBuffer s = new StringBuffer("");
            movie[i] = String.valueOf(s.append(sc.nextInt()));
        }

        StringBuffer p = new StringBuffer("");
        for (int i=0;i<people;i++){
            p.append(0);
        }
        for (int i=0;i<N;i++){
            findSeat(movie[i],p);
        }


        System.out.println(count);
        


    }

    private static void findSeat(String s, StringBuffer p) {
        int seat = s.indexOf(String.valueOf(p))+1;
        if (seat>0){
            count++;
            StringBuffer im = new StringBuffer(s);
            im.replace(seat-1,seat, "1");
            findSeat(String.valueOf(im), p);
        }

    }

}
