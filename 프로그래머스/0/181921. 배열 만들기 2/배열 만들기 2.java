import java.util.*;
class Solution {
    public int[] solution(int l, int r) {
        int[] answer = {};
        List<String> arr = new ArrayList<>();
        for(int i=l;i<=r;i++){
            if(i%5==0 || i%10==0){
                arr.add(String.valueOf(i));
            }
        }
        
        List<String> parse = new ArrayList<>();
        for(String s:arr){
            //문자열 전체가 "5"와 "0"으로만 이루어졌는지 확인하는 정규표현식
            if(s.matches("[50]+")){
                parse.add(s);
            }
        }      
        if(parse.size()<=0) return new int[]{-1};
        else{
            answer = parse.stream().mapToInt(Integer::parseInt).toArray();
        }
        return answer;
    }
}