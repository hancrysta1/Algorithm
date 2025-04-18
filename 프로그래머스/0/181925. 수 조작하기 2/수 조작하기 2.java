class Solution {
    public String solution(int[] numLog) {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<numLog.length-1;i++){
            int before = numLog[i];
            int after = numLog[i+1];
            int v = after - before;
            switch(v){
                case 1:
                    sb.append("w"); break;
                case -1:
                    sb.append("s"); break;
                case 10:
                    sb.append("d"); break;
                case -10:
                    sb.append("a"); break;
            }
        }
        return sb.toString();
    }
}