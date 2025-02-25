import java.util.*;
import java.io.*;

public class Main {
    static int[][] rooms;
    static int N,M;
    static int cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        //System.out.println(Arrays.toString(toward(startX,startY,startDirection)));
        rooms = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                rooms[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] toX = {-1,0,1,0};//북남방향 전진에 해당하는 x전진배열
        int[] toY = {0,1,0,-1};//동서방향 전진에 해당하는 y전진배열
        while(true){
            if(rooms[r][c]==0){
                rooms[r][c]=-1;//현재 좌표 청소완료
                cnt++;
            }
            boolean flag=false;
            //4방 탐색
            for(int i=0;i<4;i++){
                d = (d+3)%4;
                int toR = r+toX[d];//시계 반대방향으로 돌아서 전진한 x좌표
                int toC = c+toY[d];//시계 반대방향으로 돌아서 전진한 y좌표

                if(toR>=0 && toR<N && toC>=0 && toC<M && rooms[toR][toC]==0){//좌표 벗어나지않고 청소할 수 있는 방이면
                    r = toR; c = toC;
                    flag=true;
                    break;//탐색 끊어주기
                }
            }
            if(!flag){
                //4방 모두 청소되었거나 벽이면 후진
                int tempD = (d+2)%4;
                int backR = r+toX[tempD];//방향 그대로 후진한 x좌표
                int backC = c+toY[tempD];
                if(backR>=0 && backR<N && backC>=0 && backC<M && rooms[backR][backC]!=1){
                    r = backR; c = backC;
                }else{//후진 못하면(벽이라서)
                    break;//종료
                }
            }

        }
        System.out.println(cnt);

    }


}

