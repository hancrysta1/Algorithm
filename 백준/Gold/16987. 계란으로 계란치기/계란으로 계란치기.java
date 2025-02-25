

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
//친다=dfs
//손에 든 계란이 깨졌거나 깨지지 않은 다른 계란이 없으면 치지 않고 넘어간다. --조건1
//최근에 든 계란이 가장 오른쪽에 위치한 계란일 경우 계란을 치는 과정을 종료 --조건2
public class Main {
    static int N;
    static int[] force;
    static int[] weight;
    static int max=Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        force = new int[N];
        weight = new int[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            force[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }
        //System.out.println(Arrays.toString(force));
        dfs(0,0);//첫번째 계란으로 시작
        System.out.println(max);
    }
    public static void dfs(int start,int cnt){//순열
        if(start==N){
            max = Math.max(max,cnt);
            return;
        }
        if(force[start]<=0){
            dfs(start+1,cnt);
            return;
        }
        boolean flag=false;
        for(int i=0;i<N;i++){
            if(start==i) continue;
            if(force[i]<=0) continue;
            force[start]-=weight[i];
            force[i]-=weight[start];
            flag=true;
            int add = 0;
            if(force[start]<=0) add++;
            if(force[i]<=0) add++;
            dfs(start+1,cnt+add);
            force[start]+=weight[i];
            force[i]+=weight[start];
        }
        if(!flag){
            dfs(start+1,cnt);
            return;
        }
    }
}

