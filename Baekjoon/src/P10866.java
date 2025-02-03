import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class P10866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        sc.nextLine();
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < test; i++){
            String[] str = sc.nextLine().split(" ");

            switch (str[0]){
                case "push_front":
                    deque.addFirst(Integer.parseInt(str[1]));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(str[1]));
                    break;
                case "pop_front":
                    if (deque.isEmpty()) sb.append("-1\n");
                    else sb.append(deque.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    if (deque.isEmpty()) sb.append("-1\n");
                    else sb.append(deque.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    if (deque.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case "front":
                    if (deque.isEmpty()) sb.append("-1\n");
                    else sb.append(deque.peekFirst()).append("\n");
                    break;
                case "back":
                    if (deque.isEmpty()) sb.append("-1\n");
                    else sb.append(deque.peekLast()).append("\n");
                    break;
            }
        }
        System.out.print(sb);
        sc.close();
    }
}
