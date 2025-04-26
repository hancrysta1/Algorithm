import java.util.*;
class Solution {
    public int solution(int[] arr, int idx) {
        int answer = 0;
        List<Integer> indexes = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(i>=idx && arr[i]==1) indexes.add(i);
        }
        if(indexes.size()<=0) return -1;
        
        int[] candidate = indexes.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(candidate);
        return candidate[0];
    }
}