import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer=true;
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(') stack.push(c);//c-> Character / unboxing
            else {
                if(stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        return stack.isEmpty();
    }
}