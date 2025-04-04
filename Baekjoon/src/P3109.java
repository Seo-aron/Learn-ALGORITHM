import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3109 {
    static int col;
    static int row;
    static char[][] map;
    static boolean[][] visited;
    static int ans = 0;

    public static boolean dfs(int y, int x){
        if (!visited[y][x] && x == col - 1) {
            visited[y][x] = true;
            ans++;
            return true;
        }

        visited[y][x] = true;

        int[] dy = {-1, 0, 1};

        for (int i = 0; i < 3; i++){
            int ny = y + dy[i];
            int nx = x + 1;

            if (ny >= 0 && ny < row && nx < col && !visited[ny][nx] && map[ny][nx] == '.'){
                if(dfs(ny, nx)) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new char[row][col];
        visited = new boolean[row][col];

        for (int y = 0; y < row; y++) {
            String line = br.readLine();
            for (int x = 0; x < col; x++){
                map[y][x] = line.charAt(x);
            }
        }

        for (int i = 0; i < row; i++){
            boolean test = dfs(i, 0);
        }

        System.out.println(ans);
    }
}
