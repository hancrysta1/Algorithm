import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        List<Integer> divide = new ArrayList<>(); 
        for(int i=1;i<=n;i++){
            if(n%i==0) divide.add(i);
        }
        for(int j=0;j<divide.size();j++){
            answer += divide.get(j);
        }
        
        return answer;
    }
}