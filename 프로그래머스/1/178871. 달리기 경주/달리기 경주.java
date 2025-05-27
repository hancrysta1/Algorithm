import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String,Integer> ranks = new HashMap<>();
        Map<Integer,String> reverseRanks = new HashMap<>();
        for(int i=1;i<=players.length;i++){
            ranks.put(players[i-1],i);
            reverseRanks.put(i,players[i-1]);
        }
        
        for(String s:callings){
            int preRank = ranks.get(s)-1;
            String prePlayer = reverseRanks.get(preRank);
            ranks.put(s,preRank);
            ranks.put(prePlayer,preRank+1);
            reverseRanks.put(preRank,s);
            reverseRanks.put(preRank+1,prePlayer);
        }
        for(Map.Entry<String,Integer> x:ranks.entrySet()){
            answer[x.getValue()-1]=x.getKey();
        }
        return answer;
    }
}