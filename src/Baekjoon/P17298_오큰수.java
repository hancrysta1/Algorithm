package Baekjoon;

import java.io.*;
import java.util.Stack;

public class P17298_오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int A[] = new int[N];
        int oken[] = new int[N];
        //배열 입력받는 방법(1) String 배열로 split()해서 먼저 받아놓고 반복문 돌며 형 변환하기
        //배열 입력받는 방법(2) Tokenizer 이용해서 쪼개놓고 반복문 돌며 형 변환하기
        //지금은 (1) 방법을 쓸 예정
        String str[] = br.readLine().split(" "); //readLine은 기본으로 string으로 읽히기 때문에 형 변환 필요 없음
        for (int i=0;i< N;i++){
            A[i] = Integer.parseInt(str[i]);
        }
        Stack<Integer> myStack = new Stack<>();
        myStack.push(0);//비어있는 스택에 0을 먼저 넣고 초기화
        for (int i=1;i<N;i++){ //현재 : peek() , 오큰 수 비교 대상 : i
            while (!myStack.isEmpty() && A[myStack.peek()] < A[i]){//스택이 비어있지 않고, 현재가 오큰 수를 발견할 경우
                oken[myStack.pop()] = A[i]; //현재의 인덱스에 오큰 수 데리고 떠나버린다. (peek이 현재인데 떠나버리니 pop됨)
            }
            myStack.push(i); //오큰 수 발견 X일 경우 발견할 때까지 push
        }//N번 돌기 루프
        while (!myStack.empty()){//N번 돌고 나왔는데 스택이 비어있지 않다면
            oken[myStack.pop()] = -1;//오큰 수 발견 못한 안타까운 칭구들(예를 들어 오른 쪽 수가 없는 맨 끝 데이터 등) -1 할당
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=0;i<N;i++){
            bw.write(oken[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
