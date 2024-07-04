import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();
        
        for(int i:arr){
            if(i%divisor==0){
                answer.add(i);
            }
        }
        if(answer.isEmpty()) answer.add(-1);
        int[] result = new int[answer.size()];
        for(int j=0;j<answer.size();j++){
            result[j] = answer.get(j);
        }
        Arrays.sort(result);
        return result;
    }
}