import java.util.*;
class Solution {
    public String solution(String phone_number) {
        char[] number = phone_number.toCharArray();

        List<String> list = new ArrayList<>();
        for(int i=0;i< number.length-4;i++){
            list.add("*");
        }

        for(int i=number.length-4;i<number.length;i++){
            list.add(String.valueOf(number[i]));
        }
        
        StringBuilder sb = new StringBuilder();
        list.stream().forEach(x -> sb.append(x));
        String answer = sb.toString();
        return answer;
    }
}