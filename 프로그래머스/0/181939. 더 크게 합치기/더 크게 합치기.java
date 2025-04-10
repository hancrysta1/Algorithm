class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int case_first = Integer.parseInt(String.valueOf(a)+String.valueOf(b));
        int case_second = Integer.parseInt(String.valueOf(b)+String.valueOf(a));
        
        
        return case_first>case_second?case_first:case_second;
    }
}