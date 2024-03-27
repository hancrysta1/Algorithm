import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());//BufferedReader와 StringTokenizer는 짝꿍
        double n1 = Double.parseDouble(st.nextToken());
        double n2 = Double.parseDouble(st.nextToken());
        System.out.println(n1/n2);


    }
}