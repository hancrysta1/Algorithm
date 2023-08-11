package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12891_DNA비밀번호 {
    static int charArr[];//최소한 포함되어야 할 알파벳을 담은 배열
    static int myArr[];
    static int checkSecret; //---> 전역 변수로 선언
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int count = 0;
        char A[] = new char[S];//입력받을 배열
        charArr = new int[4];//꼭 들어가야 할 4자리 수를 담은 배열
        myArr = new int[4];//checkArr과 비교할, 내 슬라이딩윈도우 범위 안에 4자리 수 체크한 배열
        checkSecret=0;
        A = br.readLine().toCharArray();//한 줄로 입력받아서 char 배열로 전환 -토큰화 안해도 되네?
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<4;i++){
            charArr[i] = Integer.parseInt(st.nextToken());//입력 꼭 받아야 할 4자리 알파벳 각각 몇개 씩 받을건지 입력받기
            if(charArr[i]==0){
                checkSecret++; //받아야 되는 수가 0개라면 이미 충족했으므로 ++
            }
        }
        for (int i=0;i<P;i++){//(1) P 범위까지(최초)
            //P는 슬라이딩 윈도우 범위 크기, 배열 A를 P까지만 돈다.
            Add(A[i]);
        }

        if (checkSecret==4){
            count++; //문자 하나 하나 정해진 조건 충족할 때만 카운트하는 checkSecret이니, 4가 된다는 건
            //네 글자 모.두. 조건을 충족한다는 이야기가 되므로, count해준다.
        }
        for (int i=P;i<S;i++){//(2) P 이후부터(한칸 씩 이동)
            int j = i-P;//P이후의 첫번 째 원소, 두번 째 원소를 하나씩.. 배열 S 끝나기 전까지 한 칸 한칸 살펴볼 예정
            Add(A[i]);//한 칸마다 판단하기, 얘는 어디에 추가 돼?
            Remove(A[j]);//슬라이딩 윈도우 범위에서 벗어난 애들, 이젠 판단 범위가 아니니 count 해줬으면 미련없이 버리자.
            //처음부터 끝까지 일일히 비교하기엔 연산이 커지니 원래 있던 범위에서 하나 추가, 하나 삭제해가며 값 비교한다. (슬라이딩 윈도우 핵심)
            if (checkSecret==4){
                count++;
            }
        }
        System.out.println(count);
        br.close();
    }

    private static void Add(char c) {
        switch (c){
        case 'A':
            myArr[0]++;//카운트(배열 바구니에 담기)
            if(myArr[0] == charArr[0])//정한 숫자에 들어맞으면
                checkSecret++;//조건 충족한다고 ++
            break;
        case 'C':
            myArr[1]++;//카운트(배열 바구니에 담기)
            if(myArr[1] == charArr[1])//정한 숫자에 들어맞으면
                checkSecret++;//조건 충족한다고 ++
            break;
        case 'G':
            myArr[2]++;//카운트(배열 바구니에 담기)
            if(myArr[2] == charArr[2])//정한 숫자에 들어맞으면
                checkSecret++;//조건 충족한다고 ++
            break;
        case 'T':
            myArr[3]++;//카운트(배열 바구니에 담기)
            if(myArr[3] == charArr[3])//정한 숫자에 들어맞으면
                checkSecret++;//조건 충족한다고 ++
            break;
        }
    }

    private static void Remove(char c) {
        switch (c){
        case 'A':
            if(myArr[0] == charArr[0])
                checkSecret--;
            myArr[0]--;
            break;
        case 'C':
            if(myArr[1] == charArr[1])
                checkSecret--;//조건 충족한다고 ++
            myArr[1]--;
            break;
        case 'G':
            if(myArr[2] == charArr[2])//정한 숫자에 들어맞으면
                checkSecret--;//조건 충족한다고 ++
            myArr[2]--;
            break;
        case 'T':
            if(myArr[3] == charArr[3])
                checkSecret--;
            myArr[3]--;
            break;
        }
    }



}
