package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P11268_절댓값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2) -> {
            int first = Math.abs(o1);
            int second = Math.abs(o2);
            if (first == second){//만약 절댓값이 똑같다면
                return  o1 > o2 ? 1 : -1; //원본값 비교하여 음수 우선 정렬하기 - 아 return이라는 게, 큐에 들어간다는 뜻이구나!
            }else
                return first - second;//절댓값 기준으로 정렬하기  //** 이 부분 살짝 이해가 안감
        });
        for (int i=0;i<N;i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(myQueue.isEmpty()){
                    System.out.println(0);
                }else
                    System.out.println(myQueue.poll());//우선 순위 정렬 된 큐에서 front 값을 꺼내서 출력
            }else {
                myQueue.add(x); //0이 아닌 값이 x에 입력됐으면 그대로 큐에 집어넣기
            }
        }
    }
}
