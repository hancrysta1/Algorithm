package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253_좋은수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Long A[] = new Long[N];
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);
        for (int k =0;k<N;k++){
            long find = A[k];
            int i = 0;//sp : 처음
            int j = N-1;//ep : 끝

            //투 포인트 알고리즘
            while (i<j){//while(i<j) 요게 이 알고리즘의 특징인듯하다.
                if (A[i] + A[j] == find){ //(1)
                    if (i!=k && j !=k){ //자기 자신을 좋은 수에 포함하면 안됨..(1,k) 안됨
                        count++;// 배열 돌며 A[k]를 만드는 두 수를 만나면 카운트
                        break; //if문은 여기서 break; (2)로 갑니다.
                    } else if (i == k) {
                        i++; //i가 k와 같으면 다음 수로 넘어 가서 수색
                    } else if (j == k) {
                        j--; //j가 k와 같으면 다음 수로 넘어 가서 수색
                    }
                }else if (A[i] + A[j] < find){ //(2) 아직 작아?
                   i++; //늘려가보자~
                }else {
                    j--; //넘으면, 줄여보자~ 큰거부터.
                }
            }
        }
        System.out.println(count);
        br.close();

    }
}
