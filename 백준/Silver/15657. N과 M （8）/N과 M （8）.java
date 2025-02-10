
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] Nlist;
    static StringBuffer sb;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Nlist = new int[N];
        for(int i=0;i<N;i++){
            Nlist[i] = Integer.parseInt(st.nextToken());
        }
        //System.out.println(Arrays.toString(Nlist));
        sb = new StringBuffer();
        Arrays.sort(Nlist);
        //1,7 -> 7,1 X이므로 조합 + 1 1 가능하므로 visited배열 필요 없음(같은 것 중복 방문 가능)
        visited = new boolean[N];
        backtrack(0,new ArrayList<>());
        System.out.println(sb);
    }
    public static void backtrack(int startIdx,ArrayList<Integer> curr){
        //탈출
        if(curr.size()==M){
            for(int x:curr){
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        //recursive
        for(int i=startIdx;i<N;i++){
            curr.add(Nlist[i]);
            backtrack(i,curr);
            curr.remove(curr.size()-1);
        }
    }

}