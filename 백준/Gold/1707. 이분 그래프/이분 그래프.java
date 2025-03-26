//package org.server;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<K;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] graph = new ArrayList[V+1];
            for(int j=1;j<=V;j++){
                graph[j]=new ArrayList<>();
            }
            for(int j=0;j<E;j++){
                st = new StringTokenizer(br.readLine());
                int fromNode = Integer.parseInt(st.nextToken());
                int toNode = Integer.parseInt(st.nextToken());
                graph[fromNode].add(toNode);
                graph[toNode].add(fromNode);
            }
            int[] colors = new int[V+1];
            boolean flag = true;
            
            for(int z=1;z<=V;z++){
                if(colors[z]==0&&!bfs(z,graph,colors)){
                    flag=false;
                    break;
                }
            }
            sb.append(flag?"YES\n":"NO\n");
        }
        
        
        
        System.out.println(sb.toString());
    
    }
    public static boolean bfs(int start,ArrayList<Integer>[] graph,int[] colors){
        ArrayDeque<Integer> que = new ArrayDeque<>();
        que.add(start);
        colors[start]=1;
        while(!que.isEmpty()){
            int curr=que.poll();
            for(int next:graph[curr]){
                if(colors[curr]==colors[next]){
                    return false;
                }else{
                    if(colors[next]==0){
                        colors[next]=colors[curr]*-1;
                        que.add(next);
                    }
                }
    
            }
        }
        
        return true;
    }
        
}
