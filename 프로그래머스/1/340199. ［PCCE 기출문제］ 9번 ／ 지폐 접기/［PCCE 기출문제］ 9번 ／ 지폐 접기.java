import java.util.*;
class Solution {
    public int solution(int[] wallet, int[] bill) {
        int cnt = 0;
        int min = Math.min(wallet[0],wallet[1]);
        int max = Math.max(wallet[0],wallet[1]);
        while(true){
            if((min>=bill[0] && max>=bill[1]) || (min>=bill[1] && max>=bill[0])) break;
            if(bill[0]>bill[1]){
                bill[0]=bill[0]/2;
                cnt++;
            }else if(bill[0]<bill[1]){
                bill[1]=bill[1]/2;
                cnt++;
            }
        }
        
        
        return cnt;
    }
}