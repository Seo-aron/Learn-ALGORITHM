import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] table = new int[n+1][n+1];
        int[][] sum = new int[n+1][n+1];

        for (int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=n; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + table[i][j];
            }
        }

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            int ans = sum[y2][x2] - sum[y1-1][x2] - sum[y2][x1-1] + sum[y1-1][x1-1];
            System.out.println(ans);
        }
    }
}
