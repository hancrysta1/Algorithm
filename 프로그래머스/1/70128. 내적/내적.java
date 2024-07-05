class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        int multiply=0;
        for(int i=0;i<a.length;i++){
            multiply = a[i]*b[i];
            answer += multiply;
        }
        return answer;
    }
}