import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int 안전영역() throws IOException {
        //그래프 입력받기 + 최대 높이 찾기(max잠김)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        int max_height=0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(max_height<graph[i][j]){
                    max_height=graph[i][j];
                }
            }
        }

        //System.out.println(Arrays.deepToString(graph));
        int max_cnt=0;//답이 될 최대 카운트
        for(int k=0;k<max_height;k++) {//강수량마다 잠기는 부분 체크
            boolean[][] down = new boolean[n][n];//false로 매번 초기화
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (k >= graph[i][j]) {
                        down[i][j] = true;//강수량k에따라 잠기는 부분들
                    }
                }
            }
            //count하기
            int cnt=0; //초기화되어야함
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(!down[i][j]){
                        dfs(i,j,n,down);
                        cnt++;
                    }
                }
            }
            if(max_cnt<cnt){
                max_cnt=cnt;
            }

        }
        return max_cnt;
    }

    public static void dfs(int i, int j, int n, boolean[][] down) {
        int[] toX = {-1,1,0,0};
        int[] toY = {0,0,-1,1};
        down[i][j]=true;
        for(int k=0;k<4;k++){
            int x=i+toX[k];
            int y=j+toY[k];
            if(x>=0&&y>=0&&x<n&&y<n&&!down[x][y]){
                dfs(x,y,n,down);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //p2468_안전영역 ay = new p2468_안전영역();
        int answer = 안전영역();
        System.out.println(answer);
    }


}
