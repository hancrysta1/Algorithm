
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        //순열 구하기(1,1 중복허용-> visited 필요 없음)
        backtrack(new ArrayList<>());
        System.out.println(sb);
    }
    public static void backtrack(ArrayList<Integer> curr){
        if(curr.size()==M){
            for(int x:curr){
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1;i<=N;i++){
            curr.add(i);
            backtrack(curr);
            curr.remove(curr.size()-1);
        }
    }
}

