//package org.server;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Map<String,int[]> eggs;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        eggs = new HashMap<>();
        eggs.putIfAbsent("fragile",new int[N]);
        eggs.putIfAbsent("weight",new int[N]);
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            eggs.get("fragile")[i] = Integer.parseInt(st.nextToken());
            eggs.get("weight")[i] = Integer.parseInt(st.nextToken());
        }
        //System.out.println(Arrays.toString(eggs.get("fragile")));
        max=0;
        backtrack(0);
        System.out.println(max);
    }
    public static void backtrack(int start){//curr리스트 대신 인덱스로 dfs하는 방법
        if(start==N){
            int count=0;
            for(int i=0;i<N;i++){
                if(eggs.get("fragile")[i]<=0) count++;
            }
            max = Math.max(max,count);
            return;
        }
        if(eggs.get("fragile")[start]<=0){
            backtrack(start+1);
            return;//깨진 계란이 다른 계란을 칠 수 있는 가능성을 차단
        }
        boolean isSmashed=false;
        for(int i=0;i<N;i++){//다른 계란 돌기
            if(i==start || eggs.get("fragile")[i]<=0 || eggs.get("fragile")[start]<=0) continue;//깨졌거나 자기 자신이면 패스
            eggs.get("fragile")[start] -= eggs.get("weight")[i];
            eggs.get("fragile")[i] -= eggs.get("weight")[start];
            isSmashed = true;//다른 계란 침
            backtrack(start+1);
            eggs.get("fragile")[start] += eggs.get("weight")[i];
            eggs.get("fragile")[i] += eggs.get("weight")[start];
        }
        if(!isSmashed){
            backtrack(start+1);
        }
    }
}

