import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cls = Integer.parseInt(st.nextToken());
        int blue = Integer.parseInt(st.nextToken());
        int[] gl = new int[cls];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cls; i++) {
            gl[i] = Integer.parseInt(st.nextToken());
        }
    }
}
