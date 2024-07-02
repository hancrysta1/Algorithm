import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String[] tostr = String.valueOf(n).split("");
        
        for(String s:tostr){
            answer += Integer.parseInt(s);
        }

        return answer;
    }
}