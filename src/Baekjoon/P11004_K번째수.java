package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class P11004_K번째수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int A[] = new int[N];
        for (int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(A,0,N-1,K-1);
        //System.out.println(A[K-1]); //방법(1) println
        StringBuilder sb = new StringBuilder(String.valueOf(A[K-1]));
        System.out.println(sb);// 방법(2) StringBuilder
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  // IOException 예외처리 필요
//        bw.write(String.valueOf(A[K-1]));// BufferedWriter 를 사용하려면 String 형으로 변환이 필요하다.
//        bw.flush();
//        bw.close();// 방법(3) BufferedReaders
        br.close();
    }

    public static void quickSort(int[] a, int S, int E, int K) {
        //S부터E까지 가진 배열 a[]의 K번째 수 구하기
        if(S<E){
            int pivot = partition(a,S,E);
            if (pivot==K) //K가 피벗이면 더이상 구할 필요 없음
                return;
            else if (K<pivot) { //K가 피벗보다 작으면 왼쪽 그룹만 정렬 수행하기
                quickSort(a,S,pivot-1,K);
            }
            else //K가 피벗보다 크면 오른쪽 그룹만 정렬 수행하기
                quickSort(a,pivot+1,E,K);
        }
    }

    public static int partition(int[] a, int s, int e) {
        int M = (s+e)/2; //배열의 중앙값 구하기
        swap(a,s,M); //배열의 시작과 중앙값 서로 swap --> 중앙값은 피벗이 되고 연산이 쉽도록 맨 앞으로 보내기
        int pivot = a[s]; //배열의 중앙값(시작으로 온 중앙값)을 피벗으로 할당
        int i = s, j = e;
        while (i<j){
            while (pivot < a[j]){
                j--;//피벗값과 비교- 비굣값이 더 크면 앞으로 한칸씩 마이너스 -계속 반복
            }//i,j가 역전되지 않으면서 && 피벗보다 큰 수가 나올 때까지 한칸씩 플러스 ++ - 계속 반복
            while (i<j && pivot >= a[i]){
                i++;
            }
            swap(a,i,j); //그러다 s(=i)와 e(=j)가 만나면 스왑
        }
        a[s] = a[i];
        a[i] = pivot;
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
