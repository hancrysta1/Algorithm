//package org.server;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> circle = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            circle.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while(!circle.isEmpty()){
            for(int i=0;i<K-1;i++){
                circle.add(circle.poll());
            }
            sb.append(circle.poll());
            if(!circle.isEmpty()) sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}
