import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        graph = new ArrayList[N];//N개 공간 만들겠다 -> N 초기화 필요
        for(int i=0;i<N;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i=0;i<N;i++){
            DFS(i,1);
            if(flag) break;//하나라도 나오면 반복문 중단
        }
        System.out.println(flag?1:0);
    }

    private static void DFS(int startNode, int depth) {
        if(depth==5||flag){
            flag=true;
            return;
        }
        visited[startNode]=true;

        for(int x:graph[startNode]){
            if(!visited[x]){
                DFS(x,depth+1);
            }
        }
        
        visited[startNode]=false;
    }
}

