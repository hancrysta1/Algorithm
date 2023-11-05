package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2178_미로탐색 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;
    static int[][] A;
    static int N,M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N][M];
        visited = new boolean[N][M];
        for (int i=0;i<N;i++){
            for (int j=0;i<M;j++){
                A[i][j] = sc.nextInt();
            }
        }
        BFS(0,0);//좌표 x,y /  처음은 (0,0)에서 시작
        System.out.println(A[N-1][M-1]);
    }

    private static void BFS(int i, int j) { //BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j}); //큐에 해당 좌표 집어넣고
        while (!queue.isEmpty()){ //큐가 빌 때까지 반복
            int now[] = queue.poll(); //큐에서 좌표 값(0,0) 뽑아 배열에 담고
            visited[i][j] = true; //좌표 방문 여부 표시
            for (int k=0;k<4;k++){ //동서남북
                int x = now[0] + dx[k]; //now에 담은 0번째 값은 x좌표이고 + 좌우 돌아가며 위치 선정
                int y = now[1] + dy[k]; //now에 담은 1번째 값은 y좌표이고 + 위아래 돌아가며 위치선정
                if (x >= 0 && y >= 0 && x<N && y<M){ //각 x,y좌표가 범위 내에만 있다면- 형식상 조건
                    //좌표 유효성 검사하기
                    if (A[x][y] != 0 && !visited[x][y]){ //좌표값이 1이고 방문 안했다면
                        visited[x][y] = true; //방문 표시하고
                        A[x][y] = A[now[0]][now[1]]+1; //이해X 왜.. 지금 좌표에 1을 더한 값을 현재 위치에 덮어씌우는거지?
                        queue.add(new int[]{x,y}); //연결된 1이 또 있을 때 그걸 큐에 담는다는건가?
                    }
                }
            }
        }
    }

}