//package org.server;
import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        //System.out.println(K);

        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        
        
        for(int j=0;j<M;j++){
            st = new StringTokenizer(br.readLine());
            int fromNode = Integer.parseInt(st.nextToken());
            int toNode = Integer.parseInt(st.nextToken());
            graph[fromNode].add(toNode);//단방향
        }
        int[] visited = new int[N+1];
        Arrays.fill(visited, -1);
        
        ArrayDeque<Integer> que = new ArrayDeque<>();
        ArrayList<Integer> answer = new ArrayList<>();
        que.add(X);
        visited[X]=0;//가장 처음은 0으로 초기화
        while (!que.isEmpty()) {
            int curr = que.poll();
            
            for(int next:graph[curr]){
                if(visited[next]==-1){
                    que.add(next);
                    visited[next]=visited[curr]+1;
                }
                
            }
        }
        for(int i=1;i<=N;i++){
            //System.out.println(visited[i]);
            if(visited[i]==K){
                answer.add(i);
            }
        }
        if(answer.size()==0){
            System.out.println(-1);
        }else{
            Collections.sort(answer);
            for(int x:answer){
                System.out.println(x);
            }
            
        }
        
    }
        
}
