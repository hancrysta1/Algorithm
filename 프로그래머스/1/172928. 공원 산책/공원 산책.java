import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        int width = park.length;
        int height = park[0].length();
        int[] start = {};
        char[][] park_Arr = new char[width][height];
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                if(park[i].charAt(j)=='S') start = new int[]{i,j};
                park_Arr[i][j] = park[i].charAt(j);
            }
        }
        
        for(int i=0;i<routes.length;i++){
            String[] ops = routes[i].split(" ");
            String op = ops[0];
            int blocks = Integer.parseInt(ops[1]);
            switch(op){
                case "N":
                    if(isGoingUpDown(start,-blocks,width,park_Arr)){
                        start[0]-=blocks;
                    } break;
                case "S":
                    if(isGoingUpDown(start,blocks,width,park_Arr)){
                        start[0]+=blocks;
                    } break;
                case "W":
                    if(isGoingLeftRight(start,-blocks,height,park_Arr)){
                        start[1]-=blocks;
                    } break;
                case "E":
                    if(isGoingLeftRight(start,blocks,height,park_Arr)){
                        start[1]+=blocks;
                    } break;
                default: break;
            }
            //System.out.println(Arrays.toString(start));
        }
        return start;
    }
    public boolean isGoingUpDown(int[] move,int blocks,int width,char[][] park_Arr){
        int target = move[0]+blocks;
        if(target>=0 && target<width){
            if(target<move[0]){
                for(int t=move[0];t>=target;t--){
                    if(park_Arr[t][move[1]]=='X') return false;
                }
            }else{
                for(int t=move[0];t<=target;t++){
                    if(park_Arr[t][move[1]]=='X') return false;
                }
            }
            return true;
        }
        
        return false;
    }
    public boolean isGoingLeftRight(int[] move,int blocks,int height,char[][] park_Arr){
        int target = move[1]+blocks;
        if(target>=0 && target<height) {
            if(target<move[1]){
                for(int t=move[1];t>=target;t--){
                    if(park_Arr[move[0]][t]=='X') return false;
                }
            }else{
                for(int t=move[1];t<=target;t++){
                    if(park_Arr[move[0]][t]=='X') return false;
                }
            }
            
            return true;
        }
        
        return false;
    }
}