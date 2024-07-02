import java.util.*;
class Solution {
    public long solution(long n) {
        String[] arr = String.valueOf(n).split("");
        Arrays.sort(arr);
        String con = arr[arr.length-1];
        for(int i=1;i<arr.length;i++){
            con+=arr[arr.length-1-i];
        }
        return Long.parseLong(con);
    }
}