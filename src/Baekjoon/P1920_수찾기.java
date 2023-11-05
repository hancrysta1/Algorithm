package Baekjoon;
import java.util.*;
public class P1920_수찾기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for(int i=0;i<N;i++){
            A[i] = sc.nextInt();
        }

        //찾을 대상이 되는 배열 A 선 정렬
        Arrays.sort(A);//기본 : 오름차 순 정렬


        int M = sc.nextInt();
        for(int i=0;i<M;i++){
            boolean find = false;
            int s = sc.nextInt();
            int start = 0;
            int end = N-1;
            while (start<=end){
                int mid = (start+end)/2; // start, end값이 계속 업데이트 되므로, 유동적인 mid값을 설정
                int midV = A[mid];
                if(midV>s){
                    end = mid-1;
                }else if(midV<s){
                    start = mid+1;
                }else{ //A배열은 정렬되었다는 전체가 있어 가능한 알고리즘. 탐색하다보면 없는 값은 시작 값 == 끝 값이 됩니당
                    find = true;
                    break;
                }
            }
            if (find){
                System.out.println(1);
            }else {
                System.out.println(0);
            }
        }


    }
}
