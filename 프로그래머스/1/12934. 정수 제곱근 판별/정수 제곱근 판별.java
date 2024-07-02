class Solution {
    public long solution(long n) {
        long sqrt = (long)Math.sqrt(n);  // 제곱근을 long 타입으로 캐스팅
        if (sqrt * sqrt == n) {  // sqrt의 제곱이 n과 같은지 확인
            return (sqrt + 1) * (sqrt + 1);  // (sqrt + 1)의 제곱을 반환
        } else {
            return -1;  // n이 제곱수가 아니면 -1 반환
        }
    }
}
