import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int suNo = Integer.parseInt(st.nextToken());//tokenizer로 쪼갠 첫 원소 할당
        int quizNo = Integer.parseInt(st.nextToken());
        long[] S = new long[suNo+1];
        st = new StringTokenizer(br.readLine());//reader로 다시 읽어
        for(int i =1;i<=suNo;i++){
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());//합배열
        }
        for(int q=0;q<quizNo;q++){
            st = new StringTokenizer(br.readLine());//reader로 다시 읽어
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());//그때마다 입력 받아서
            System.out.println(S[j] - S[i-1]);
        }
    }
}
