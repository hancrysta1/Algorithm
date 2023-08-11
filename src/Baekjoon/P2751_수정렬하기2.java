package Baekjoon;

import java.io.*;

public class P2751_수정렬하기2 {
    public static int[] A,tmp;
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        A = new int[N+1];

        tmp = new int[N+1];
        for (int i=1;i<=N;i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        merge_sort(1,N);
        for (int i=1;i<=N;i++){
            bw.write(A[i]+"\n");
        }
        bw.flush();
        bw.close();
    }

    private static void merge_sort(int s, int e) {
        if(e-s <1) return;
        int m = s + (e-s) / 2;//중간 수 찾기
        //재귀 (최초 배열 반 갈라)
        merge_sort(s,m);//처음~중간 그룹
        merge_sort(m+1,e);//중간~끝 그룹
        for (int i=s;i<=e;i++){ //주어진 처음부터 끝까지 정렬 수행
            tmp[i] = A[i]; //비교를 위해 임시 배열에 담아주기
        }
        int k = s;
        int index1 = s; //전체의 절반) 첫번 째 그룹의 포인터
        int index2 = m+1; //전체의 절반) 두번 째 그룹의 포인터
        while (index1 <=m && index2 <=e){
            //각 포인터가 그룹의 끝까지 가면 루프 종료
            if(tmp[index1] > tmp[index2]){
                A[k] = tmp[index2]; //더 작은 값을 덮어씌우기
                k++;
                index2++;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }//tmp값을 비교해가며 A 배열에 차례로 넣어주세욥
        }//한 쪽 그룹이 다 정리가 되면
        while (index1 <= m){ //나머지는 쭉 집어넣기
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        while (index2 <= e){ //나머지는 쭉 집어넣기
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
