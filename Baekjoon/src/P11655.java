import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(ROT13(str));
    }

    private static String ROT13(String str){
        StringBuilder sb = new StringBuilder();

        for(char ch : str.toCharArray()){
            if(ch >= 'A' && ch <= 'Z'){
                sb.append((char) ((ch - 'A' + 13) % 26 + 'A'));
            } else if (ch >= 'a' && ch <= 'z') {
                sb.append((char) ((ch - 'a' + 13) % 26 + 'a'));
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
