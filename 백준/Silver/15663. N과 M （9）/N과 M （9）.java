import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int N;
    static int M;
    static Integer[] arr;
    static boolean[] visited;
    static Set<String> result;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());//length
        st = new StringTokenizer(br.readLine());
        sb=new StringBuilder();
        arr = new Integer[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        visited = new boolean[arr.length];
        result = new LinkedHashSet<>();
        //순열
        backtrack(new ArrayList<>());
        //Set<String> realResult = new LinkedHashSet<>(result.stream().map(String::toString).collect(Collectors.toSet()));
        sb = new StringBuilder();
        for(String x:result){
            sb.append(x).append("\n");
        }
        System.out.println(sb);
    }
    public static void backtrack(ArrayList<Integer> curr){
        if(curr.size()==M){
            sb = new StringBuilder();
            for(int x:curr){
                sb.append(x).append(" ");
            }
            result.add(String.valueOf(sb).trim());
            //System.out.println(sb);

            return;
        }
        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i]=true;
                curr.add(arr[i]);
                backtrack(curr);
                visited[i]=false;
                curr.remove(curr.size()-1);
            }
        }
    }
}

