class Solution {
    public long getsum(int a,int b){
        long sum = 0;
        for(int i=a;i<=b;i++){
            sum+=i;
        }
        return sum;
    }
    public long solution(int a, int b) {
        if(a==b){
            return a;
        }else if(a<b){
            return getsum(a,b);
        }else{
            return getsum(b,a);
        }
    }
}