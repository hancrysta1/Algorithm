
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] klist;
    static ArrayList<int[]> inputs;
    static StringBuffer sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int K;
        inputs = new ArrayList<>();
        //무한으로 입력받다가 0입력되면 입력 종료
        while(true){
            String input = br.readLine();
            if (input == null || input.trim().isEmpty()) {
                break;  // 입력이 없거나 비어 있으면 종료
            }
            st = new StringTokenizer(input);
            K = Integer.parseInt(st.nextToken());
            //System.out.println(K);
            if(K==0) break;
            klist = new int[K];
            for (int i=0;i<K;i++){
                klist[i] = Integer.parseInt(st.nextToken());
            }
            //System.out.println(Arrays.toString(klist));
            Arrays.sort(klist);
            //배열을 리스트에 넣을 경우 : klist가 가리키는 원본이 아니라 새로운 배열을 복사하여 저장하므로 이후 klist가 변경되어도 리스트 내부 값은 바뀌지 않는다.
            inputs.add(Arrays.copyOf(klist,klist.length));//length도 함께 저장해줄 것
        }
        sb = new StringBuffer();
        for(int i=0;i<inputs.size();i++){
            backtrack(0,i,new ArrayList<>());
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void backtrack(int startIdx,int startCurrIdx,ArrayList<Integer> curr){
        if(curr.size()==6){
            for(int x:curr){
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int j=startIdx;j<inputs.get(startCurrIdx).length;j++){
            curr.add(inputs.get(startCurrIdx)[j]);
            backtrack(j+1,startCurrIdx,curr);
            curr.remove(curr.size()-1);
        }

    }

}

