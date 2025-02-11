
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<Integer, ArrayList<Integer>> graph;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph = new HashMap<>();
        for(int i=1;i<=N;i++){
            graph.put(i,new ArrayList<>());
        }
        StringTokenizer st;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        //System.out.println(graph);

        boolean[] visited = new boolean[N+1];
        cnt = 0;
        dfs(1,visited);
        System.out.println(cnt-1);
    }
    public static void dfs(int startNode,boolean[] visited){
        if(visited[startNode]) return;
        visited[startNode]=true;
        cnt+=1;
        for(int x: graph.get(startNode)){
            dfs(x,visited);
        }
    }
}

