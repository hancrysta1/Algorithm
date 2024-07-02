class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int sum = 0;
        String[] xs = String.valueOf(x).split("");
        for(String i:xs){
            sum += Integer.parseInt(i);
        }
        if (x%sum == 0) answer= true;
        else answer= false;
        return answer;
    }
}