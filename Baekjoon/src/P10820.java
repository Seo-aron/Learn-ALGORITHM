import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10820 {
    public static void main(String[] args) throws IOException {
        // 출력 소문자, 대문자, 숫자, 공백
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = br.readLine()) != null){
            int[] result = new int[4];

            for (char ch : str.toCharArray()){
                if(ch >= 'a' && ch <= 'z'){
                    result[0] += 1;
                } else if(ch >= 'A' && ch <= 'Z'){
                    result[1] += 1;
                } else if(ch >= '0' && ch <= '9'){
                    result[2] += 1;
                } else if(ch == ' '){
                    result[3] += 1;
                }
            }
            System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + result[3]);
        }
    }
}
