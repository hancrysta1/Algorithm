//package org.server;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] sums = new int[N+1];
        for(int s=1;s<=N;s++){
            sums[s] = sums[s-1]+Integer.parseInt(st.nextToken());
        }//합배열 미리 구하기
        StringBuilder sb = new StringBuilder();
        for(int z=0;z<M;z++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            sb.append(sums[j]-sums[i-1]).append("\n");
        }
        System.out.println(sb.toString());
    }
        
}
