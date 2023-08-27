package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

@SuppressWarnings("unchecked")
public class P24479_알고리즘수업_깊이우선탐색 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> A = new ArrayList<>();//정점들의 정보를 기록할 그래프
    static int[] visited;
    static int count; //순회 순서

    public static void main(String[] args) throws IOException {
         st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new int[N+1];
        for (int i=0;i<N+1;i++){
            A.add(new ArrayList<>());
        }
        for (int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A.get(s).add(e);
            A.get(e).add(s); //양방향이므로 양쪽에 더하기
        }
        //오름차순 정렬 / 예를 들어 1-4, 1-2 연결이라면 입력 순서 상관없이 1-2가 제일 먼저 순회되도록
        for (int i=1;i<A.size();i++){
            Collections.sort(A.get(i)); //A 그래프의 i 가져와서 해당하는 내용을 오름차순 정렬
        }
        count = 1; // 시작 정점도 순회 순서에 포함
        DFS(R); //DFS 재귀 시작
        for (int i=1;i<visited.length;i++){
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }
    private static void DFS(int R) {
        visited[R] = count;//현재 방문하고 있는 정점에 순서 저장, 최초 : 정점(1)-순서(1)

        for(int i=0;i<A.get(R).size();i++){ //현재 위치한 정점이 갈 수 있는 정점 리스트를 순회
            // 정점 1에서 어디까지 갈 수 있나? == A.get(1).size()
            int newV = A.get(R).get(i); //정점 1과 이어진 노드들 하나씩 탐색(i) == 깊이 우선 탐색
            //정수 형태의 변수에 해당 정점 저장하고서

            //해당 정점을 이전에 방문했었는지 체크(0일 경우 방문안한거임. 방문 시 순서가 매겨지므로)
            if(visited[newV] == 0){
                count++; // 방문 순서대로 정점에 순서 정보가 매겨짐.
                DFS(newV); // 1-2 였다면 2와 이어진 또 다른 정점들을 깊이 우선 탐색.
            }
        }
    }
}
