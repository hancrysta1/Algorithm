//push X: 정수 X를 큐에 넣는 연산이다.
//        pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//size: 큐에 들어있는 정수의 개수를 출력한다.
//        empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
//front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<N;i++){
            String command = br.readLine();
            if(command.startsWith("push")){
                queue.add(Integer.parseInt(command.split(" ")[1]));
            } else if(command.equals("pop")){
                if(queue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(queue.poll()).append("\n");
            } else if(command.equals("size")){
                sb.append(queue.size()).append("\n");
            } else if(command.equals("empty")){
                sb.append(queue.isEmpty()?1:0).append("\n");
            } else if(command.equals("front")){
                if(queue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(queue.peek()).append("\n");
            } else if(command.equals("back")){
                if(queue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(((LinkedList<Integer>)queue).getLast()).append("\n");
            }
        }
        System.out.println(sb);

    }
}

