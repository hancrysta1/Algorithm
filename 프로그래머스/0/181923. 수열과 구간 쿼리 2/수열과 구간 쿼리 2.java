import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        Arrays.fill(answer,-1);
        for(int x=0;x<queries.length;x++){
            List<Integer> candidate = new ArrayList<>();
            int s = queries[x][0];
            int e = queries[x][1];
            int k = queries[x][2];
            
            for(int i=0;i<arr.length;i++){
                if(0<=i && s<=i && i<=e && e<arr.length){
                    candidate.add(arr[i]);
                }
            }
            
            //System.out.println(candidate);
            int min = Integer.MAX_VALUE;
            for(int i=0;i<candidate.size();i++){
                if(k<candidate.get(i) && min>candidate.get(i)){
                    //System.out.println(candidate.get(i));
                    min = candidate.get(i);
                    answer[x] = candidate.get(i);
                }
            }
        }
        return answer;
    }
}