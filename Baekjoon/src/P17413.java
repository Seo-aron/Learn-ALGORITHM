import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        boolean tag = false;

        for(char c : str.toCharArray()){
            if (c == '<'){
                while (!stack.isEmpty()){
                    result.append(stack.pop());
                }
                result.append(c);
                tag = true;
            } else if (c == '>'){
                result.append(c);
                tag = false;
            } else if (tag) {
                result.append(c);
            } else {
               if (c == ' '){
                   while (!stack.isEmpty()){
                       result.append(stack.pop());
                   }
                   result.append(c);
               } else {
                   stack.push(c);
               }
            }
        }
        while (!stack.isEmpty()){
            result.append(stack.pop());
        }
        System.out.println(result);
    }
}
