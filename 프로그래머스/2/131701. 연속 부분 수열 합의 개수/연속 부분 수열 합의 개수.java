import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int len = elements.length;
        int[] elementsDouble = new int[len*2];
        
        for(int i=0;i<len;i++){
            elementsDouble[i]=elements[i];
            elementsDouble[i+len]=elements[i];
        }
        Set<Integer> sums = new HashSet<>();
        for(int i=1;i<=len;i++){
            int sum =0;
            
            for(int j=0;j<i;j++){//윈도우 내부 탐색
                sum+=elementsDouble[j];
                
            }
            sums.add(sum);
            for(int x=1;x<len;x++){
                sum = sum-elementsDouble[x-1]+elementsDouble[x+i-1];
                sums.add(sum);
            }
            
        }
        return sums.size();
    }
}