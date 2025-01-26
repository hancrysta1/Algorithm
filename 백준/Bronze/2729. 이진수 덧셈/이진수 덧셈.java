import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            String second = st.nextToken();
            BigInteger num1 = new BigInteger(first, 2);
            BigInteger num2 = new BigInteger(second, 2);
            BigInteger sum = num1.add(num2);

            System.out.println(sum.toString(2));//이진수로 출력
        }
    }

}