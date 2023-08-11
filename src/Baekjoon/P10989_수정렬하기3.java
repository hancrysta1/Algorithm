package Baekjoon;

import java.io.*;

public class P10989_수정렬하기3 {
    public static int[] A;
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        for (int i=0;i<N;i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Radix_Sort(A,5);
        for (int i=0;i<N;i++){
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void Radix_Sort(int[] A, int max) {
        int[] output = new int[A.length];
        int jarisu = 1; //1의 자리부터
        int cnt = 0;
        while (cnt != max){
            int[] bucket = new int[10]; //자리수 버킷
            //일의 자리 수 버킷 담기
            for (int i=0;i<A.length;i++){ //배열 값 돌며
                bucket[(A[i] / jarisu) % 10]++;//해당 값의 1의 자릿수가 3이라면 버킷3에 카운트++
            }//자리 수 값대로 버킷에 담았으면
            for (int i = 1;i<10;i++){
                bucket[i] += bucket[i-1]; // 구간 합 : S[i]  = S[i-1] + A[i]
            }//버킷 합 배열 만들기
            for(int i=A.length-1;i>=0;i--){
                output[bucket[A[i] / jarisu % 10]-1] = A[i];
                bucket[A[i] / jarisu % 10]--;
            }
            for (int i=0;i<A.length;i++){
                A[i] = output[i];
            }
            jarisu = jarisu *10; //다음 자리수로 넘어가기
            cnt++;
        }
    };
}
