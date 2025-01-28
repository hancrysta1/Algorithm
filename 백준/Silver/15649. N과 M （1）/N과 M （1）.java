import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int M;
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        visited= new boolean[N+1];
        backtrack(new ArrayList<>(),1);
        System.out.println(sb);
    }
    public static void backtrack(ArrayList<Integer> curr,int startNode) {
        if(curr.size()==M){
            for (int num : curr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1;i<=N;i++){
            if(!visited[i]){
                visited[i]=true;
                curr.add(i);
                backtrack(curr, i+1);
                visited[i]=false;
                curr.remove(curr.size()-1);
            }
        }


    }
}