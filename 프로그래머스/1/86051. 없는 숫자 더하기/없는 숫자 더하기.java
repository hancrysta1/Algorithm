import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int[] all = {0,1,2,3,4,5,6,7,8,9};
        List<Integer> except = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();//numbers -> arr
        int answer=0;
        for (int i:numbers){
            arr.add(i);
        }
        for(int j:all){
            if(!arr.contains(j)) except.add(j);
            else continue;
        }
        for(int k=0;k<except.size();k++){
            answer += except.get(k);
        }
        return answer;
    }
}