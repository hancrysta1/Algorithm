
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static StringBuilder sb;
    static int[] arr;
    static boolean[] visited;
    static Set<String> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());//1~N
        M = Integer.parseInt(st.nextToken());//length
        sb = new StringBuilder();//result
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        result = new LinkedHashSet();
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));

        backtrack(0,new ArrayList<>());

        for(String x:result){
            System.out.println(x);
        }
    }
    public static void backtrack(int start,ArrayList<Integer> curr){
        if(curr.size()==M){
            sb = new StringBuilder();
            for(int x:curr){
                sb.append(x).append(" ");
            }
            if(!result.contains(sb)) result.add(String.valueOf(sb));
            //sb.append("\n");
            return;
        }
        for(int i=start;i<N;i++){
            if(!visited[i]){
                visited[i]=true;
                curr.add(arr[i]);
                backtrack(i+1,curr);
                visited[i]=false;
                curr.remove(curr.size()-1);
            }
        }
    }
}

