package Baekjoon;

import java.util.*;

public class F번_벼락치기 {
        static Scanner s = new Scanner(System.in);
        static int N;
        static int T;

        static int days[];
        static int[] fines;
        static String[] copy;
        static int plan;

        public static void main(String[] args) {
            N = s.nextInt();
            T = s.nextInt();
            days = new int[N];
            fines = new int[N];
            copy = new String[N];

            for(int i = 0; i < N; i++){
                days[i] = s.nextInt();
                int temp = s.nextInt();
                fines[i] = temp;
                copy[i] = String.valueOf(temp);
            }

            //study(fines,days,copy);
            for (int i=0;i<N;i++){
                String max = String.valueOf(Arrays.stream(fines).max().getAsInt());
                int index = Arrays.asList(copy).indexOf(max);
                if (index>-1){
                    plan += days[index];
                    if (plan<=T){
                        days[index] = 0;
                        fines[index] = 0;
                    }
                }
            }

            int sum = Arrays.stream(fines).sum();
            System.out.println(sum);

        }

//    private static void study(int[] fines, int[] days,String[] copy) {
//        String max = String.valueOf(Arrays.stream(fines).max().getAsInt());
//        int index = Arrays.asList(copy).indexOf(max);
//        if (index>-1){
//            plan += days[index];
//            if (plan<=T){
//                days[index] = 0;
//                fines[index] = 0;
//                study(fines,days,copy);
//            }
//        }
//
//    }
}

