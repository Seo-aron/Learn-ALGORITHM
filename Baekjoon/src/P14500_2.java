import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14500_2 {
    static int n;
    static int m;
    static int[][] field;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int ans= 0;

    private static void exceptetro(int y, int x){
        int sum = 0;

        if(y-1 >= 0 && x-1 >= 0 && x+1 < m) {
            sum = field[y][x] + field[y-1][x] + field[y][x-1] + field[y][x+1];
            if (ans < sum) ans = sum;
        }
        if(y+1 < n && x-1 >= 0 && x+1 < m) {
            sum = field[y][x] + field[y+1][x] + field[y][x-1] + field[y][x+1];
            if (ans < sum) ans = sum;
        }
        if(x-1 >= 0 && y-1 >= 0 && y+1 < n) {
            sum = field[y][x] + field[y-1][x] + field[y][x-1] + field[y+1][x];
            if (ans < sum) ans = sum;
        }
        if(y-1 >= 0 && y+1 < n && x+1 < m) {
            sum = field[y][x] + field[y-1][x] + field[y+1][x] + field[y][x+1];
            if (ans < sum) ans = sum;
        }
    }

    private static void tetroDfs(int y, int x, int count, int sum){
        if (count == 4) {
            if (ans < sum) ans = sum;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx]) continue;
            visited[ny][nx] = true;
            tetroDfs(ny, nx, count+1, sum + field[ny][nx]);
            visited[ny][nx] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        field = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                tetroDfs(i, j, 1, field[i][j]);
                exceptetro(i, j);
                visited[i][j] = false;
            }
        }

        System.out.println(ans);
    }
}
