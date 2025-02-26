import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] result = new int[26];
        StringBuilder sb = new StringBuilder();

        for (char ch : str.toCharArray()){
            if (ch >= 'a' && ch <= 'z'){
                result[ch-'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
