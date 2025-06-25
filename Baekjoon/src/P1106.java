import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Hotel {
    int cost, pop;

    public Hotel(int cost, int pop) {
        this.cost = cost;
        this.pop = pop;
    }
}

public class P1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int customer = Integer.parseInt(st.nextToken());
        int city = Integer.parseInt(st.nextToken());

        List<Hotel> hotels = new ArrayList<>();

        for (int i=0; i<city; i++){
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int pop = Integer.parseInt(st.nextToken());
            hotels.add(new Hotel(cost, pop));
        }

        int MAX_CUSTOMER = customer + 100;
        int[] dp = new int[MAX_CUSTOMER];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (Hotel h : hotels) {
            for (int i = h.pop; i < MAX_CUSTOMER; i++) {
                if (dp[i - h.pop] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i - h.pop] + h.cost);
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = customer; i < MAX_CUSTOMER; i++) {
            answer = Math.min(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
