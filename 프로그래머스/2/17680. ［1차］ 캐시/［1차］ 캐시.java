import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int time=0;
        String[] after_city = new String[cities.length];
        Queue<String> que = new ArrayDeque<>();
        for(int i=0;i<cities.length;i++){
            after_city[i] = cities[i].toLowerCase();
        }
        for(int i=0;i<after_city.length;i++){
            if(cacheSize>que.size()& !que.contains(after_city[i])){//최초 넣기(miss)
                que.add(after_city[i]);
                time+=5;
            }else if(que.contains(after_city[i])){
                //System.out.println(after_city[i]);
                que.remove(after_city[i]);
                que.add(after_city[i]);
                time+=1;
            }else if(que.size()>0){
                que.poll();
                que.add(after_city[i]);
                time+=5;
            }else{
                time+=5;
            }
            
        }
        
        
        return time;
    }
}