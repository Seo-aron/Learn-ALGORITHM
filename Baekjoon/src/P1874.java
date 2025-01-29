import java.util.Scanner;
import java.util.Stack;

public class P1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int lastPush = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++){
            num = sc.nextInt();

            if (lastPush < num) {
                for (int j = lastPush + 1; j <= num; j++) {
                    stack.push(j);
                    result.append("+\n");
                }
                lastPush = num;
            }
            if(stack.peek() == num){
                stack.pop();
                result.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(result);
    }
}