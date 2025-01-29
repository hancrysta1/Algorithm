import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int S;
    static int[] arr;
    static boolean[] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());//N개의 숫자
        S = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //합이 S가 되는 부분 수열 구하기 -> 조합
        //조합을 일일히 구할 필요가 없음 -> sum만 체크한다.
        backtrack(0,0);//인덱스
        System.out.println(count);
    }
    public static void backtrack(int index, int sum){
        if(index==N) return; //특이하다! "인덱스가 N이 되지 않는 이상 return 안하겠다."
        if(sum+arr[index]==S){
            count+=1;
        }
        backtrack(index+1,sum);
        backtrack(index+1,sum+arr[index]);
    }
}

