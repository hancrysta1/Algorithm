import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    //에라토르테네스 방식으로 풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] V = new int[N+1];

        for (int i=2;i<=N;i++){
            V[i] = i;
        }

        for (int i=2;i<=Math.sqrt(N);i++){
            if(V[i]==0){
                continue;
            }
            for(int j=i+i;j<=N;j=j+i){
                V[j] = 0;
            }
        }

        for(int i=M;i<=N;i++){
            if(V[i]!=0) System.out.println(V[i]);
        }

    }
}
