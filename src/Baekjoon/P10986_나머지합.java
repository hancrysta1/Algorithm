package Baekjoon;

import java.util.Scanner;

public class P10986_나머지합 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] S = new long[N];
        long[] C = new long[M];
        long answer = 0;
        S[0] = sc.nextInt();
        for(int i =1;i<N;i++){ //합배열
            S[i] = S[i-1] + sc.nextInt();
        }
        for (int i=0;i<N;i++){
            int remainder = (int) (S[i]%M); //합배열 루트 돌며 나머짓값 구하기
            if(remainder==0) answer++; //나누어떨어지면 카운트
            C[remainder]++; //바구니에 하나씩 담기
        }

        for(int i =0;i<M;i++){
            if(C[i]>1){
                //나머지 같은 인덱스 중 2개 뽑는 경우의 수를 더하기(2개 뽑는다 = 쌍을 뽑는다.)
                //나머지가 같은 애들끼린 구간합 구하면 M으로 나누어 떨어지는 규칙이 있음
                answer += (C[i] * (C[i]-1)/2);
            }
        }
        System.out.println(answer);
    }

}
