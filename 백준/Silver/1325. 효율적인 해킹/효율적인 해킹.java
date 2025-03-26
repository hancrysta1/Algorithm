//package org.server;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[B].add(A);
        }
        
        int[] answer = new int[N+1];
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=N;i++){
            boolean[] visited = new boolean[N+1];
            answer[i]=bfs(i,visited,graph);
            max = Math.max(max,answer[i]);
        }
        // System.out.println("최대값: "+max);
        // System.out.println(Arrays.toString(answer));
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<answer.length;i++){
            if(answer[i]==max){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString());

    }
    public static int bfs(int start,boolean[] visited,ArrayList<Integer>[] graph){
        ArrayDeque<Integer> que = new ArrayDeque<>();
        que.add(start);
        visited[start]=true;
        int cnt=0;
        while(!que.isEmpty()){
            int node = que.poll();
            for(int x:graph[node]){
                if(!visited[x]){
                    visited[x]=true;
                    que.add(x);
                    cnt++;
                }
            }
        }
        return cnt;
    }
        
}
