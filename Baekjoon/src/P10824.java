import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        if (st.countTokens() != 4) {
            return;
        }
        String num1 = st.nextToken();
        String num2 = st.nextToken();
        String num3 = st.nextToken();
        String num4 = st.nextToken();

        String str1 = num1 + num2;
        String str2 = num3 + num4;

        System.out.println(Long.parseLong(str1) + Long.parseLong(str2));
    }
}
