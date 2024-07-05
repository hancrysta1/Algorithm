import java.util.*;
class Solution {
    public String solution(int n) {
        String answer = "";
        List<String> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i%2!=0){
                arr.add(i,"박");
            }else{
                arr.add(i,"수");
            }
        }
        for(int i=0;i<arr.size();i++){
            answer += arr.get(i);
        }
        
        return answer;
    }
}