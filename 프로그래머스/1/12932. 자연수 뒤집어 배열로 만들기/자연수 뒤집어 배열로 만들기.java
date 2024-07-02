import java.util.*;
class Solution {
    public int[] solution(long n) {
        String[] s = String.valueOf(n).split("");
        int[] answer = new int[s.length];
        for (int i=0;i<answer.length;i++){
            answer[i] = Integer.parseInt(s[answer.length-1-i]);
        }
        for(int i:answer){
            System.out.println(i);
        }

        return answer;
    }
}