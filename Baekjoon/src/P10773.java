import java.util.Scanner;
import java.util.Stack;

public class P10773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < testCase; i++){
            int num = sc.nextInt();

            if (num == 0){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.push(num);
            }
        }

        int sum = 0;
        while (!stack.isEmpty()){
            sum = sum + stack.pop();
        }
        System.out.println(sum);
    }
}
