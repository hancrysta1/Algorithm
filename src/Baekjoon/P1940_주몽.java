package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1940_주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());//줄 단위로 입력 받음
        int[] A = new int[N];//N 크기의 빈 배열 선언하고
        StringTokenizer st = new StringTokenizer(br.readLine());//한 줄 입력받아 토큰화
        for (int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());//토큰을 반복문 돌며 배열에 배정해줌
        }
        Arrays.sort(A); // 입력 받은 데이터가 랜덤이므로 연산이 쉽도록 오름차순 정렬
        int count = 0;
        int i = 0;//sp : 맨 처음부터 시작(min)
        int j = N-1;//ep :  맨 끝부터 시작(max)
        while (i<j) { //i는 ++ j는 -- 연산하다가 둘이 만날 수도 있음, i가 j를 역전하면 안됨
            if(A[i] + A[j] < M){
                i++;//값이 부족하면 조금씩 추가해보기
            }else if(A[i] + A[j] > M){
                j--;//값이 크면 큰 것부터 좀 줄여나가기 --
            }else {
                count++;
                i++;
                j--; // 값이 같으면 카운트해주고 한 칸씩 전진하여 다음 단계로
            }
        }
        System.out.println(count);
        br.close();
    }
}
