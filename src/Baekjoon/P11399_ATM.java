package Baekjoon;
import java.util.*;
public class P11399_ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //사람 수
        int[] A = new int[N]; //한 사람 당 걸리는 시간을 저장
        int[] S = new int[N]; //합 배열

        for(int i=0;i<N;i++){
            A[i] = sc.nextInt();
        }
        for(int i=0;i<N;i++){ //삽입 정렬
            int ip = i;
            int v = A[i];
            for(int j=i-1;j>=0;j--){
                if(A[j]<A[i]){
                    ip = j+1;
                    break;
                }
                if(j==0){
                    ip = 0;
                }
            }
            for(int j=i;j>ip;j--){
                A[j] = A[j-1];
            }
            A[ip] = v;
        }//end of for i
        S[0] = A[0];
        for(int i=1;i<N;i++){
            S[i] = S[i-1] + A[i];
        }
        int sum = 0;
        for(int i=0;i<N;i++){
            sum += S[i];
        }
        System.out.println(sum);

        }
}
