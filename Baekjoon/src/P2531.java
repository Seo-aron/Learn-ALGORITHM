import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int plate = Integer.parseInt(st.nextToken());
        int sushiType = Integer.parseInt(st.nextToken());
        int eatCount = Integer.parseInt(st.nextToken());
        int coupon = Integer.parseInt(st.nextToken());

        int[] sushi = new int[plate];
        int[] sushiCount = new int[sushiType + 1];
        int currentCount = 0;

        for (int i = 0; i < plate; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < eatCount; i++) {
            if(sushiCount[sushi[i]] == 0) currentCount++;
            sushiCount[sushi[i]]++;
        }
        // 쿠폰 초밥이 내 접시에 없어야지 +1
        int max = currentCount + (sushiCount[coupon] == 0 ? 1 : 0);

        for (int i = 1; i < plate; i++) {
            int remove = sushi[i - 1];
            int add = sushi[(i + eatCount - 1) % plate];

            sushiCount[remove]--;
            if (sushiCount[remove] == 0) currentCount--;

            if (sushiCount[add] == 0) currentCount++;
            sushiCount[add]++;

            int nowMax = currentCount + (sushiCount[coupon] == 0 ? 1 : 0);
            max = Math.max(max, nowMax);
        }

        System.out.println(max);
    }
}
