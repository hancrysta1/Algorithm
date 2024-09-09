

import java.util.Scanner;

public class Main {
    static int M; //밭의 가로
    static int N; //밭의 세로
    static int K; //배추심어진 위치 갯수
    static int[][] graph;
    static boolean[][] visited;

    static int[] upd = {-1,1,0,0};
    static int[] leftr = {0,0,-1,1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t=0;t<T;t++){
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();
            graph = new int[M][N];
            visited = new boolean[M][N];
            for (int k=0;k<K;k++){
                graph[sc.nextInt()][sc.nextInt()]=1;
            }//밭의 모양 구현 완료

            int worm = 0; //벌레 수

            for (int i = 0;i<M;i++){
                for (int j=0;j<N;j++){
                    if (graph[i][j] ==1 && !visited[i][j]){
                        DFS(i,j);
                        worm++;
                    }
                }
            }
            System.out.println(worm);
        }

    }

    public static void DFS(int w, int q) {
        visited[w][q] = true;

        for (int i=0;i<4;i++){
            int wu = w + upd[i];
            int ql = q + leftr[i];

            if (wu>=0 && ql>=0 && wu<M && ql<N){
                if (graph[wu][ql] == 1 && !visited[wu][ql]){
                    DFS(wu,ql);
                }
            }
        }

    }
}
