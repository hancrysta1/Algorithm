import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class dfsbfs {
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int start = sc.nextInt();
        A = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            A[i] = new ArrayList<Integer>(); //인접리스트 순서대로 할당
        }
        for(int i=0;i<M;i++){
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
            A[E].add(S);
        }//그래프 완성

        for(int i=0;i<N;i++){
            Collections.sort(A[i]);//만들어지며 순서가 섞였을지도 모르니, 작은 노드부터 방문 위해 구조 개편. 오름차 순 정렬
        }

        visited = new boolean[N+1];
        DFS(start);
        System.out.println();
        visited = new boolean[N+1];
        BFS(start);
        System.out.println();

    }
    private static void BFS(int Node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(Node);//시작노드부터 큐에 들어간다.
        visited[Node] = true;//BFS는 큐에 넣자마자 visited 체크해주자.

        while(!queue.isEmpty()){
            //큐가 비워질 때까지 무한반복
            int now_Node = queue.poll();
            System.out.println(now_Node+" ");
            for(int i : A[now_Node]){
                if(!visited[i]){
                    visited[i] = true;//BFS는 큐에 넣자마자 visited 체크해주자.
                    queue.add(i);//안들어간 애는 그냥 큐에 넣으면 된다. 재귀함수 호출할 필요X
                }
            }
        }

    }
    private static void DFS(int Node) {
        System.out.println(Node+" ");
        visited[Node] = true;
        for(int i : A[Node]){//한 노드 당 ArrayList 할당되어 방문 노드들 루프 돌며 찾고 안들어간 애들
            if(!visited[i]){
                DFS(i);//fuction call하여 분기 끝까지 반복
            }
        }
    }


}
