import java.util.*;
class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer = {};
        switch(n){
            case 1:
                answer = slicing(0,slicer[1],1,num_list); break;
            case 2:
                answer = slicing(slicer[0],num_list.length-1,1,num_list); break;
            case 3:
                answer = slicing(slicer[0],slicer[1],1,num_list); break;
            default:
                answer = slicing(slicer[0],slicer[1],slicer[2],num_list); break;
                
        }
        return answer;
    }
    
    public int[] slicing(int start,int end,int step,int[] num_list){
        List<Integer> result = new ArrayList<>();
        for(int i=start;i<=end;i+=step){
            result.add(num_list[i]);
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}