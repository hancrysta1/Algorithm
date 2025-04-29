import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] query) {
        for(int x=0;x<query.length;x++){
            if(x%2==0){
                arr = Arrays.copyOfRange(arr,0,query[x]+1);
            }else{
                arr = Arrays.copyOfRange(arr,query[x],arr.length);
            }
        }
        
        return arr;
    }
}