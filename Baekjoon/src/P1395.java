import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P1395 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String notation = br.readLine();
        double[] values = new double[length];
        Stack<Double> stack = new Stack<Double>();
        double num1 = 0, num2 = 0;
        for (int i = 0; i < length; i++){
            values[i] = Double.parseDouble(br.readLine());
        }

        for (int i = 0; i < notation.length(); i++) {
            char ch = notation.charAt(i);
            if (ch >= 'A' && ch <= 'Z'){
                stack.push(values[ch - 'A']);
            } else {
                num1 = stack.pop();
                num2 = stack.pop();

                switch (notation.charAt(i)){
                    case '+':
                        stack.push(num2 + num1);
                        break;
                    case '-':
                        stack.push(num2 - num1);
                        break;
                    case '*':
                        stack.push(num2 * num1);
                        break;
                    case '/':
                        stack.push(num2 / num1);
                        break;
                }
            }
        }
        System.out.printf("%.2f\n", stack.pop());
    }
}
