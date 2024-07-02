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
//런타임에러 : 리턴 값 Integer로 했을 때 났다. long 자료형이 int보다 처리할 수 있는 범위 큼. Java에서 Integer의 범위는 -2^31에서 2^31-1
    }
}
