import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class P1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int testCase = Integer.parseInt(br.readLine());

        LinkedList<Character> list = new LinkedList<>();
        for (char c : str.toCharArray()){
            list.add(c);
        }
        ListIterator<Character> cursor = list.listIterator(list.size());

        for (int i = 0; i < testCase; i++){
            String cmd = br.readLine();

            switch (cmd.charAt(0)){
                case 'L':
                    if (cursor.hasPrevious()) cursor.previous();
                    break;
                case 'D':
                    if (cursor.hasNext()) cursor.next();
                    break;
                case 'B':
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                    break;
                case 'P':
                    cursor.add(cmd.charAt(2));
                    break;
            }
        }

        StringBuilder result = new StringBuilder();
        for (char s : list){
            result.append(s);
        }
        System.out.println(result);
    }
}
