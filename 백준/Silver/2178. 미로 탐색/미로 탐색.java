import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int answer=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<int[]> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        que.offer(new int[]{0,0,1});
        int[] toX={-1,1,0,0};int[] toY={0,0,-1,1};
        while(!que.isEmpty()) {
            int[] cur = que.poll();
            int x=cur[0];int y=cur[1];
            int cnt=cur[2];
            if(x==n-1&&y==m-1){
                answer=cnt;
                System.out.println(answer);
            }
            for(int i=0;i<4;i++){
                int nx=x+toX[i];
                int ny=y+toY[i];
                if(nx>=0&&ny>=0&&nx<n&&ny<m&&graph[nx][ny]!=0){
                    if(!visited[nx][ny]){
                        visited[nx][ny]=true;
                        que.offer(new int[]{nx,ny,cnt+1});
                    }
                }
            }
        }
    }
}
