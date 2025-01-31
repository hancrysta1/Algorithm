
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static StringBuilder sb;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());//1~N
        M = Integer.parseInt(st.nextToken());//length
        sb = new StringBuilder();//result
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        backtrack(0,new ArrayList<>());
        System.out.println(sb);
    }
    public static void backtrack(int start,ArrayList<Integer> curr){
        if(curr.size()==M){
            for(int x:curr){
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i]=true;
                curr.add(arr[i]);
                backtrack(start+1,curr);
                visited[i]=false;
                curr.remove(curr.size()-1);
            }
        }
    }
}

