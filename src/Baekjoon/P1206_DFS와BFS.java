package Baekjoon;

import java.util.*;

public class P1206_DFS와BFS {
    static boolean visited[];
    static ArrayList<Integer>[] A;//연결리스트로 구성된 Int형 배열
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        A = new ArrayList[n+1];

        for (int i=1;i<=n;i++){
            A[i] = new ArrayList<>();
        }//하나의 인덱스에 여러개 넣고 싶을 때 이렇게 초기화하기
        for (int i=0;i<m;i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
            A[e].add(s);//양방향리스트
        }
        for (int i=1;i<=n;i++){
            Collections.sort(A[i]);
        }//인덱스 순회하며 각 방에 담긴 숫자들 오름차순(기본)으로 정렬

        visited = new boolean[n+1];

        DFS(v);
        System.out.println();
        visited = new boolean[n+1];

        BFS(v);
        System.out.println();


    }

    private static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now+" ");
            for (int i : A[now]){
                if (!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    private static void DFS(int v) {
        System.out.print(v+" ");
        visited[v] = true;
        for (int i : A[v]){
            if (!visited[i]){
                DFS(i);
            }//순회 중 만난 노드, 방문 안했니? 너부터 방문 쭉 하자
        }
    }
}
