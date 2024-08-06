import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int rooms = places.length;
        int[] result = new int[rooms];
        
        Arrays.fill(result,1);
        
        for(int k=0;k<rooms;k++){
           if(!checkRooms(places[k])){
               result[k]=0;
           }
        }
        
        
        return result;
    }
    public boolean checkRooms(String[] room){
        int row=room.length;
        int col=room[0].length();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(room[i].charAt(j)=='P'){
                    if(!bfs(i,j,room,row,col)){
                        return false;
                    }
                }
            }
        } 
        return true;
    }
    
    public boolean bfs(int x,int y,String[] room,int row,int col){
        //동서남북
        int[] toX = {-1,1,0,0};
        int[] toY = {0,0,-1,1};
        Queue<int[]> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[row][col];
        que.offer(new int[]{x,y,0});
        visited[x][y]=true;
        while(!que.isEmpty()){
            int[] node=que.poll();
            int qx=node[0];
            int qy=node[1];
            int ql=node[2];
            
            if(ql>0 && room[qx].charAt(qy)=='P'){
                return false;
            }
            if(ql>=2) continue;

            for(int i=0;i<4;i++){
                int dx=qx+toX[i];
                int dy=qy+toY[i];
                if(dx>=0&&dx<row&&dy>=0&&dy<col&&!visited[dx][dy]){
                    if(room[dx].charAt(dy)!='X'){
                        que.offer(new int[]{dx,dy,ql+1});
                        visited[dx][dy]=true;
                    }
                }
            }
            
        }

        return true;
    }
}