class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long sum =0;
        for(int i=1;i<=n;i++){
            sum += x;
            answer[i-1] = sum;
        }
        return answer;
    }
}