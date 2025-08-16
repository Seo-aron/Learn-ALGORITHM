import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        int dj = Integer.parseInt(st.nextToken());
        int bj = Integer.parseInt(st.nextToken());
        List<String> list = new ArrayList<>();

        HashSet<String> set = new HashSet<>();
        for (int i=0; i < dj+bj; i++) {
            String str = br.readLine();

            if (set.contains(str)) {
                ans++;
                list.add(str);
            }
            set.add(str);
        }

        Collections.sort(list);

        System.out.println(ans);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
