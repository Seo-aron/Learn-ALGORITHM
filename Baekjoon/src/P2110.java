import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2110 {
    static int home;
    static int router;
    static int[] homeX;

    private static int isRouter(int mid) {
        int count = 1;
        int lasthome = homeX[0];

        for (int i = 1; i < homeX.length; i++) {
            if (homeX[i] - lasthome >= mid) {
                count++;
                lasthome = homeX[i];
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        home = Integer.parseInt(st.nextToken());
        router = Integer.parseInt(st.nextToken());

        homeX = new int[home];
        for (int i = 0; i < home; i++){
            homeX[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(homeX);

        int min = 1;
        int max = homeX[home - 1] - homeX[0];
        int ans = 0;

        while (min <= max) {
            int mid = (min + max) / 2;
            int install = isRouter(mid);

            // 준비된 공유기가 맞거나, 보다 많을 경우(=공유기 간의 거리를 조금 더 늘려본다)
            if (install >= router){
                ans = mid;
                min = mid + 1;
            }
            // 준비된 공유기가 남는 경우
            else {
                max = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
