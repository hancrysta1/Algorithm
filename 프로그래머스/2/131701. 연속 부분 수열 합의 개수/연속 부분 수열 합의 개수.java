import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int[] combined = new int[elements.length*2];
        for(int i=0;i<elements.length;i++){
            combined[i]=elements[i];
            combined[elements.length+i]=elements[i];
        }
        Set<Integer> sums = new HashSet<>();
        for(int i=1;i<=elements.length;i++){
            int sum = 0;
            for(int j=0;j<i;j++){
                sum+=combined[j];
                sums.add(sum);
            }
            for(int w=1;w<elements.length;w++){
                sum=sum-combined[w-1]+combined[w+i-1];
                sums.add(sum);
            }
        }
        
        return sums.size();
    }
}