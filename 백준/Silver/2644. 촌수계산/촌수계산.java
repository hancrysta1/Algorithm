import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(br.readLine());//간선 갯수=관계 갯수
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, List<Integer>> reverseMap = new HashMap<>(); // 부모-자식 관계를 역으로 저장하는 맵

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int parent=Integer.parseInt(st.nextToken());
            int child=Integer.parseInt(st.nextToken());
            map.putIfAbsent(parent,new ArrayList<>());
            map.get(parent).add(child);
            // 자식에서 부모로의 관계도 추가
            reverseMap.putIfAbsent(child, new ArrayList<>());
            reverseMap.get(child).add(parent);
        }
        int distance = bfs(a,b,n,map,reverseMap);
        System.out.println(distance);
    }

    public static int bfs(int start,int target,int n,Map<Integer,List<Integer>> map,Map<Integer,List<Integer>> reverseMap){
        Queue<Integer> que=new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        Map<Integer, Integer> levelMap = new HashMap<>();
        
        que.offer(start);
        visited[start]=true;
        levelMap.put(start,0);
        while(!que.isEmpty()){
            int node=que.poll();
            int level=levelMap.get(node);
            if(node==target){
                return level;
            }
            //level=result.get(node); //result.get(node)+1 노드(이전 레벨)이 기록 된 레벨 불러와 +1
            //map.get(node)가 null이면 nullPointException 발생 가능성 있음
            List<Integer> temp = map.getOrDefault(node, new ArrayList<>());
            for(int i:temp){
                if(!visited[i]){
                    que.add(i);
                    visited[i]=true;
                    levelMap.put(i,level+1);
                }
            }//해당 노드의 자식 먼저 순회하고,
            List<Integer> toParent = reverseMap.getOrDefault(node, new ArrayList<>());
            for(int i:toParent){
                if(!visited[i]){
                    que.add(i);
                    visited[i]=true;
                    levelMap.put(i,level+1);
                }
            }//해당 노드의 부모까지 순회한다.
        }

        return -1;
    }
}
