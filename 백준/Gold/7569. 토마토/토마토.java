//package org.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] toX = {1, -1, 0, 0, 0, 0};
    static int[] toY = {0, 0, 1, -1, 0, 0};
    static int[] toZ = {0, 0, 0, 0, 1, -1};
    static int[][][] basket;
    static int M;
    static int N;
    static int H;
    static int[][][] days;
    static Queue<int[]> que;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        basket = new int[H][N][M];
        days = new int[H][N][M];

        que = new ArrayDeque<>();
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                st = new StringTokenizer(br.readLine());
                for(int z=0;z<M;z++){
                    int input = Integer.parseInt(st.nextToken());
                    if (input == 1) {
                        que.add(new int[]{i, j, z});//출발점들 미리 큐에 넣기
                        days[i][j][z] = 0;  // 익은 토마토는 0일 (초기값)
                    }
                    else if(input==0){
                        days[i][j][z] = -1;//안익은 토마토(방문 대상) -1로 초기화
                    }
                    basket[i][j][z] = input;
                }
            }
        }

        bfs();
        int maxDays = 0;
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int z=0;z<M;z++){
                    if(days[i][j][z]==-1){
                        System.out.println(-1); return;
                    }
                    maxDays = Math.max(maxDays,days[i][j][z]);
                }
            }
        }
        System.out.println(maxDays);
    }
    public static void bfs(){
        while(!que.isEmpty()){
            int[] target = que.poll();
            int cz = target[0], cx = target[1], cy = target[2];
            for (int e = 0; e < 6; e++) {
                int dz = cz + toZ[e];
                int dx = cx + toX[e];
                int dy = cy + toY[e];
                if (dz < 0 || dz >= H || dx < 0 || dx >= N || dy < 0 || dy >= M) continue;

                if(basket[dz][dx][dy]==0 && days[dz][dx][dy]==-1){
                    days[dz][dx][dy] =days[cz][cx][cy]+1;
                    que.add(new int[]{dz,dx,dy});
                }
            }
        }
    }
}

