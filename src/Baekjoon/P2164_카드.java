package Baekjoon;
import java.util.*;
public class P2164_카드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> myQueue = new LinkedList<>();
        int N = sc.nextInt();
        for (int i =1;i<=N;i++){
            myQueue.add(i);
        }//카드를 한장 씩 큐에 저장
        
        while (myQueue.size() > 1){ //카드가 한 장 남을 때까지
            myQueue.poll();//맨 위 카드 버리고
            myQueue.add(myQueue.poll());//그 다음 카드 가장 밑으로 빼기
        }
        System.out.println(myQueue.poll());//마지막 남은 카드 출력
    }
}
