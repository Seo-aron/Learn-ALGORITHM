import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);

            // 문자열을 조작하기 위해 객체 생성
            StringBuilder result = new StringBuilder();

            while(st.hasMoreTokens()){
                String temp = st.nextToken();
                result.append(new StringBuilder(temp).reverse().append(" "));
            }
            System.out.println(result.toString().trim());
        }
    }
}
