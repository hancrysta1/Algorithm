package Baekjoon;

import java.util.Scanner;

public class P2018_수들의합5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count =  1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;
        while (end_index!=N){//1,N 을 고려해 count를 이미 했으므로 end_index가 N 이전까지만
            if(sum==N){
                count++;
                end_index++;//같으면 카운트 후 한칸 전진
                sum += end_index;//전진 후 그 다음 연산
            } else if (sum>N){
                sum -= start_index;//sum이 목표값보다 커? 그러면 sp를 한칸씩 줄이기
                start_index++;
            } else {
                end_index++;
                sum += end_index; //목표값보다 작으면 ep를 한칸씩 늘려가보자
            }
        }
        System.out.println(count);
    }
}
