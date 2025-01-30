
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static long N;
    static long M;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());//1~N
        M = Long.parseLong(st.nextToken());//length
        sb = new StringBuilder();
        backtrack(1,new ArrayList<>());
        System.out.println(sb);
    }
    public static void backtrack(long start,ArrayList<Long> curr){
        if(curr.size()==M){
            for(long x:curr){
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(long i=start;i<=N;i++){
            curr.add(i);
            backtrack(i,curr);
            curr.remove(curr.size()-1);
        }
    }
}

