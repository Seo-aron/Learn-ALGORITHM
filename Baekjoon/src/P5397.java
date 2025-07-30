import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count = Integer.parseInt(br.readLine());
        String keyLogger;

        for (int i=0; i<count; i++) {
            int cursor = 0;
            StringBuilder sb = new StringBuilder();
            List<Character> resultKey = new LinkedList<>();
            keyLogger = br.readLine();

            for (char key : keyLogger.toCharArray()) {
                switch (key) {
                    case '-':
                        if (resultKey.size() > 0 && cursor > 0) {
                            resultKey.remove(cursor-1);
                            cursor--;
                        }
                        break;
                    case '>':
                        if ((cursor+1) <= resultKey.size()) {
                            cursor++;
                        }
                        break;
                    case '<':
                        if ((cursor-1) >= 0) {
                            cursor--;
                        }
                        break;
                    default:
                        resultKey.add(cursor, key);
                        cursor++;
                        break;
                }
            }

            for (Character c : resultKey) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
