//package org.server;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }
        int cnt=0;
        int x=0;
        while(!pq.isEmpty()){
            cnt++;
            x = pq.poll();
            if(cnt==N) break;
        }

        System.out.println(x);
    }
}
