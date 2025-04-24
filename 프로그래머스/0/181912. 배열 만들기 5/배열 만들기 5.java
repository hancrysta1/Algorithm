import java.util.*;
class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> answer = new ArrayList<>();
        for(int i=0;i<intStrs.length;i++){
            int temp = Integer.parseInt(intStrs[i].substring(s,s+l));
            if(k<temp){
                answer.add(temp);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}