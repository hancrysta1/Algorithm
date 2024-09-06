
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[F+1];
        int cnt=0;
        Queue<int[]> que = new ArrayDeque<>();
        if(S==G){
            System.out.println(0);
            return;
        }
        que.add(new int[]{S,cnt});
        visited[S] = true;
        while(!que.isEmpty()){

            int[] node = que.remove();
            int start = node[0];
            cnt=node[1];

            if(start==G){
                System.out.println(cnt);
                return;
            }

            int[] toGo = new int[]{start+U,start-D};

            for(int x:toGo){
                if(x>=1 && x<=F&&!visited[x]){
                    que.add(new int[]{x,cnt+1});
                    visited[x]=true;
                }
            }
        }


        System.out.println("use the stairs");
    }
}
