import java.util.Scanner;
import java.util.Stack;

public class P10828 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < size; i++){
            String str = scanner.next();

            switch (str){
                case "push":
                    int num = scanner.nextInt();
                    stack.push(num);
                    break;
                case "pop":
                    if(stack.isEmpty()) System.out.println("-1");
                    else System.out.println(stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if(stack.isEmpty()) System.out.println("1");
                    else System.out.println("0");
                    break;
                case "top":
                    if(stack.isEmpty()) System.out.println("-1");
                    else System.out.println(stack.peek());
                    break;
                default:
                    break;
            }
        }
    }
}
