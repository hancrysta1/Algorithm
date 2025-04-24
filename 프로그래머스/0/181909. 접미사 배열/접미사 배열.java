import java.util.*;
class Solution {
    public String[] solution(String my_string) {
        List<String> dummy = new ArrayList<>();
        for(int i=0;i<my_string.length();i++){
            dummy.add(my_string.substring(i,i+(my_string.length()-i)));
        }
        String[] answer = dummy.stream().toArray(String[]::new);
        Arrays.sort(answer);
        return answer;
    }
}