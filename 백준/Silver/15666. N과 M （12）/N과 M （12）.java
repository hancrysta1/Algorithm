
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int[] numList;
    static int m;
    static StringBuffer sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Set<Integer> removeRP = new HashSet<>(Arrays.stream(nums).boxed().collect(Collectors.toSet()));
        numList = removeRP.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(numList);
        //System.out.println(Arrays.toString(numList));
        sb = new StringBuffer();
        //조합 구하기
        backtrack(0,new ArrayList<>());
        System.out.println(sb);
    }
    public static void backtrack(int startIdx,ArrayList<Integer> curr){
        if(curr.size()==m){
            for(int x:curr){
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=startIdx;i<numList.length;i++){
            curr.add(numList[i]);
            backtrack(i,curr);
            curr.remove(curr.size()-1);
        }
    }
}