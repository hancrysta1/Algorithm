class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int pos_num = excludeColon(pos);
        int video_len_num = excludeColon(video_len);
        int op_start_num = excludeColon(op_start);
        int op_end_num =  excludeColon(op_end);
        for(int i=0;i<commands.length;i++){
            //오프닝 구간에 들어왔는지 체크
            //System.out.println(pos_num+"은 "+op_start_num+"와 "+op_end_num);
            pos_num = checkOpening(pos_num,op_start_num,op_end_num);
            switch(commands[i]){
                case "next":
                    if(pos_num+10>video_len_num) 
                        pos_num = video_len_num;
                    else pos_num+=10;
                    break;
                case "prev":
                    if(pos_num>=10) pos_num-=10; 
                    else pos_num=0;
                    break;
                default:
                    break;
            }
        }
        pos_num = checkOpening(pos_num,op_start_num,op_end_num);
        //System.out.println(pos_num);
        pos_num=Math.min(video_len_num,pos_num);
        
        return insertColon(pos_num);
    }
    public int excludeColon(String time){
        String[] minutes = time.split(":");
        return Integer.parseInt(minutes[0])*60 + Integer.parseInt(minutes[1]);
    }
    public String insertColon(int time){
        int h = time/60;
        int m = time%60;
        return String.format("%02d:%02d",h,m);
    }
    public int checkOpening(int time,int start, int end){
        if(start<=time && time<=end){
            time= end;
        }
        return time;
    }
    
}