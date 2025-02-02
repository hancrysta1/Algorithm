import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<Integer> arrList;
    static StringBuffer sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Integer[] arr = new Integer[N];
        sb = new StringBuffer();
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        Set<Integer> toSet = new LinkedHashSet<>(Arrays.asList(arr));//배열->list->set으로 변환
        arrList = new ArrayList<>(toSet);//인덱스로 접근 위해 다시 리스트로 변환
        //조합
        backtrack(new ArrayList<>());
        System.out.println(sb);
    }
    public static void backtrack(ArrayList<Integer> curr){
        if(curr.size()==M){
            for(int x:curr){
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0;i<arrList.size();i++){
            curr.add(arrList.get(i));
            backtrack(curr);
            curr.remove(curr.size()-1);
        }
    }
}

