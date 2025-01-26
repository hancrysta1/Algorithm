import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean flag;
    static List<Integer>[] graph;//갯수가 정해진 리스트들이므로 배열 사용하기
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        if (N <= 0 || M < 0) {
            System.out.println(0);
            return;
        }

        visited = new boolean[N];
        graph = new ArrayList[N];//N개의 연결리스트
        for(int i=0;i<N;i++){
            graph[i] = new ArrayList<>();//공간 만들기
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for(int i=0;i<N;i++){
            if(flag) break;
            visited = new boolean[N];
            DFS(i,1);
        }
        System.out.println(flag?1:0);
    }

    public static void DFS(int start,int depth){
        if (flag) return;
        if(depth==5){
            flag=true;
            return;
        }
        visited[start]=true;
        for(int x:graph[start]){
            if(!visited[x]){
                DFS(x,depth+1);
            }
        }
        visited[start]=false;
    }

}

