class Solution {
    public int solution(String number) {
        int sum = 0;
        for(int i=0;i<number.length();i++){
            sum+=number.charAt(i)-'0';//'0'을 빼주기 = 아스키코드 사용
            //System.out.println(number.charAt(i));
        }
        
        return sum%9;
    }
}