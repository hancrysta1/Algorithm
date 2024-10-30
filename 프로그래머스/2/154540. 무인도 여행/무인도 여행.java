import java.util.*;
class Solution {
    public int[] solution(String[] maps) {
        //int[] answer = {};
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(maps[i].charAt(j)!='X'&& !visited[i][j]){
                    int sum=dfs(i,j,maps,visited);
                    answer.add(sum);
                }
            }
        }
        if(answer.size()==0){
            answer.add(-1);
        }else{
            Collections.sort(answer);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public int dfs(int x,int y,String[] maps,boolean[][] visited){
        visited[x][y]=true;
        int sum = Character.getNumericValue(maps[x].charAt(y));
        //System.out.println(sum);
        
        int[] toX={-1,1,0,0};
        int[] toY={0,0,-1,1};
        for(int c=0;c<4;c++){
            int ax = x + toX[c];
            int ay = y + toY[c];
            if(ax>=0 && ay>=0 && ax<maps.length && ay<maps[0].length() &&
               !visited[ax][ay] && maps[ax].charAt(ay)!='X'){    
                sum+=dfs(ax,ay,maps,visited);
            }
        }
        return sum;
    }
}