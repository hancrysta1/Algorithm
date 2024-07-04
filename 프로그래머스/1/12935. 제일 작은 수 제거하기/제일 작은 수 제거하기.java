import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        int[] arrOrigin = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arrCopy);
        List<Integer> li = new ArrayList<>();
        List<Integer> origin = new ArrayList<>();
        for(int i:arrCopy){
            li.add(i);
        }
        for(int i:arrOrigin){
            if(arrOrigin.length<=1) {
                return new int[] {-1};
            }
            else origin.add(i);
        }
        origin.remove(li.get(0));
        int[] answer = new int[origin.size()];

        for(int j=0;j<answer.length;j++){
            answer[j] = origin.get(j);
        }
            
        
        
        return answer;
    }
}