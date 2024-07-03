class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int value=0;
        for(int i=0;i<absolutes.length;i++){
            if(signs[i]) value=absolutes[i];
            else value=absolutes[i]*-1;
            answer+=value;
        }
        
        return answer;
    }
}