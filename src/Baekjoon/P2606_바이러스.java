package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2606_바이러스 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        int computer = Integer.parseInt(br.readLine());
        int connected = Integer.parseInt(br.readLine());
        visited = new int[computer+1];
        for (int i=0;i<computer+1;i++){
            graph.add(new ArrayList<>());
        }
        for (int i=0;i<connected;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        count = 0;
        DFS(1);
        System.out.println(count);
    }

    private static void DFS(int start) {
        visited[start] += 1;
        for (int i=0;i<graph.get(start).size();i++){
            int v = graph.get(start).get(i);

            if(visited[v]==0){
                count++;
                DFS(v);
            }

        }
    }
}
