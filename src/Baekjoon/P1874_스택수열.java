package Baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class P1874_스택수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i=0;i<N;i++){
            A[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();//String대신 사용
        int num=1;
        boolean result=true;
        for (int i=0;i<A.length;i++){
            int su = A[i];
            if(su>=num){//su가 자연수 이상일 때
                while (su>=num){
                    stack.push(num++);//num=1 우선 넣고 후위연산자 ++로 인해 2로 증가
                    bf.append("+\n");//넣을 때마다 + 문자열 추가 --> 입력된 숫자 su 전까지 add 연산 반복
                }
                stack.pop(); //그 이상 도달하면 pop
                bf.append("-\n"); //하고 - 문자열 추가
            }
            else {//push할 게 없고 오히려 빼야하면 pop
                int n = stack.pop();//현재 수열 값보다 오름차 순 자연수가 더 크면 pop으로 수열 원소 꺼냄
                if (n>su){
                    System.out.println("NO"); //스택으로 정렬이 안되는 경우. 왜냐면 수열의 su는 이미 아까 나갔기 때문
                    result=false;
                    break;
                }
                else {
                    bf.append("-\n");
                }
            }
        }
        if (result) System.out.println(bf.toString());
    }
}
