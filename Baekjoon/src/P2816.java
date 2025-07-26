import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());
        int now = 0;

        String[] ch = new String[count];
        for (int i = 0; i < count; i++) {
            ch[i] = br.readLine();
        }

        for (int i = 0; i < count; i++) {
            if (ch[i].equals("KBS1")) {
                break;
            }
            sb.append(1);
            now++;
        }

        for (int i = now; i >= 1; i--) {
            sb.append(4);
            isChange(ch, i);
            now--;
        }

        for (int i = 0; i < count; i++) {
            if (ch[i].equals("KBS2")) {
                break;
            }
            sb.append(1);
            now++;
        }

        for (int i = now; i >= 2; i--) {
            sb.append(4);
            isChange(ch, i);
            now--;
        }

        System.out.println(sb);
    }

    private static void isChange(String[] ch, int i) {
        String temp = ch[i - 1];
        ch[i - 1] = ch[i];
        ch[i] = temp;
    }
}
