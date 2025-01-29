
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int S;
    static int[] arr;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        backtrack(0,0,0);
        System.out.println(count);
    }
    public static void backtrack(int startIdx,int sum,int depth){
        if(sum==S && depth>0){//하나라도 선택했을 때(공집합X)가 조건임.S가 0일 때 공집합 해당안되게 하기
            count++;//뒤도 더 탐색해야함
        }
        for(int i=startIdx;i<N;i++){
            backtrack(i+1,sum+arr[i],depth+1);
        }
    }
}

