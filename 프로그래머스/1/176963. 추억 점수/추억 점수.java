import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        Map<String,Integer> people = new HashMap<>();
        for(int i=0;i<name.length;i++){
            people.put(name[i],yearning[i]);
        }
        int photo_cnt = photo.length;
        int[] answer = new int[photo_cnt];
        
        for(int i=0;i<photo_cnt;i++){
            int sum=0;
            for(String s:photo[i]){
                sum+=people.getOrDefault(s,0);
            }
            answer[i]=sum;
        }
        return answer;
    }
}