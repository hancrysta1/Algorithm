class Solution {
    public String solution(String my_string, String overwrite_string, int n) {
        String answer="";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(my_string.charAt(i));
        }
        sb.append(overwrite_string);
        if(my_string.length()>sb.length()){
            for(int i=n+overwrite_string.length();i<my_string.length();i++){
                sb.append(my_string.charAt(i));
            }
        }
        answer = String.valueOf(sb);
        return answer;
    }
}