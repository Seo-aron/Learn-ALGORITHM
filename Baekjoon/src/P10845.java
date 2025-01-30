import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++){
            String input = br.readLine();
            String[] str = input.split(" ");

            switch (str[0]){
                case "push":
                    int x = Integer.parseInt(str[1]);
                    queue.add(x);
                    break;
                case "pop":
                    if (queue.isEmpty()){
                        System.out.println("-1");
                        break;
                    } else {
                        System.out.println(queue.poll());
                        break;
                    }
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    if (queue.isEmpty()){
                        System.out.println("1");
                        break;
                    } else {
                        System.out.println("0");
                        break;
                    }
                case "front":
                    if (queue.isEmpty()){
                        System.out.println("-1");
                        break;
                    } else {
                        System.out.println(queue.peek());
                        break;
                    }
                case "back":
                    if (queue.isEmpty()){
                        System.out.println("-1");
                        break;
                    } else {
                        System.out.println(((LinkedList<Integer>) queue).getLast());
                        break;
                    }
            }
        }
    }
}
