import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = -1;
        Map<Integer,ArrayList<Integer>> graph = new HashMap<>();
        //그래프 만들기
        for(int i=1;i<=n;i++){
            graph.putIfAbsent(i,new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            graph.get(wires[i][0]).add(wires[i][1]);
            graph.get(wires[i][1]).add(wires[i][0]);
        }
        //끊기
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            graph.get(wires[i][0]).remove(Integer.valueOf(wires[i][1]));
            graph.get(wires[i][1]).remove(Integer.valueOf(wires[i][0]));
            boolean[] visited = new boolean[n+1];
            int cntDummy=dfs(graph,wires[i][0],visited);
            int minusValue = Math.abs((n-cntDummy)-cntDummy);
            min = Math.min(min,minusValue);
            
            graph.get(wires[i][0]).add(wires[i][1]);
            graph.get(wires[i][1]).add(wires[i][0]);
            

        }
        
        
        return min;
    }
    
    public int dfs(Map<Integer,ArrayList<Integer>> graph,int x,boolean[] visited){
        
        int cnt=1;
        visited[x]=true;
        for(int i:graph.get(x)){//되나?
            if(!visited[i]){
                cnt+=dfs(graph,i,visited);
            }
        }
        return cnt;
    }
}