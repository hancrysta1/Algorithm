

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long M;
    static long[] arr;
    static StringBuffer sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new long[N];
        for(int i=0;i<N;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        sb = new StringBuffer();
        backtrack(new ArrayList<>());
        System.out.println(sb);
    }

    public static void backtrack(ArrayList<Long> curr){
        if(curr.size()==M){
            for(long x:curr){
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0;i<N;i++){
            curr.add(arr[i]);
            backtrack(curr);
            curr.remove(curr.size()-1);
        }
    }
}

