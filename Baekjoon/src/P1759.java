import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P1759 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[] arr = new char[c];
        List<Character> result = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        passward(l, c, arr, result, 0, 0);

        System.out.println(sb);
    }

    private static void passward(int l, int c, char[] arr, List<Character> result, int start, int num) {
        if (result.size() == l) {
            if (isValid(result)){
                for (char ch : result) {
                    sb.append(ch);
                }
                sb.append("\n");
                return;
            }
            else return;
        }

        for (int i=start; i<c; i++) {
            result.add(arr[i]);
            passward(l, c, arr, result, i+1, num+1);
            result.remove(result.size() -1);
        }
    }

    private static boolean isValid(List<Character> result) {
        boolean flag = false;
        int count = 0;

        for (char ch : result) {
            if ("aeiou".indexOf(ch) >= 0) flag = true;
            else if ("bcdfghjklmnpqrstvwxyz".indexOf(ch) >= 0) count++;
        }

        if (flag && count >= 2) return true;
        else return false;
    }
}
