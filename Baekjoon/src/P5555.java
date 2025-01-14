import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5555 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < n; i++){
            String ring = br.readLine();
            String ring2 = ring + ring;
            if (ring2.contains(str)){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
