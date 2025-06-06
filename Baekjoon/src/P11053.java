import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
             a[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        list.add(a[0]);
        for (int i=1; i<n; i++){
            if (a[i] > list.get(list.size() - 1)) {
            list.add(a[i]);
            continue;
            }

            for (int j=0; j<list.size(); j++){
                if (a[i] < list.get(j)) {
                    list.set(j,a[i]);
                    break;
                }
            }
        }

        System.out.println(list.size());
    }
}
