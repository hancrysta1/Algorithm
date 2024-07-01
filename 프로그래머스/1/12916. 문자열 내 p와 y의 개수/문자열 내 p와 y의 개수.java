class Solution {
    boolean solution(String s) {
        int pcnt = 0; int ycnt = 0;
        String[] srr = s.split("");
        for (String i:srr){
            if(i.equals("p") || i.equals("P")){
                pcnt++;
            }else if(i.equals("y") || i.equals("Y")){
                ycnt++;
            }else{
                continue;
            }
        }
        if(pcnt==ycnt || pcnt == 0 && ycnt ==0) return true;
        else return false;
    }
}