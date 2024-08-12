import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < n; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }
        List<Integer> answer = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(graph[i][j] == 1 && isValid(graph,i,j)) {
                    int result = dfs(graph,i,j);//첫 시작
                    answer.add(result);//단지 별 아파트 갯수 누적
                }
            }
        }
        System.out.println(answer.size());
        Collections.sort(answer);
        for(int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }

    public static int dfs(int[][] graph,int x,int y) {
        int cnt=1;
        graph[x][y] = 0;

        int[] toX = {-1, 1, 0, 0};
        int[] toY = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            int ax = x + toX[i];
            int ay = y + toY[i];
            if (isValid(graph, ax, ay)) {
                cnt += dfs(graph, ax, ay);
            }
        }
        return cnt;
    }

    public static boolean isValid(int[][] graph,int x,int y){
        if(x<0 || x>=graph.length || y<0 || y>=graph[0].length || graph[x][y]!=1){
            return false;
        }
        return true;
    }
}
