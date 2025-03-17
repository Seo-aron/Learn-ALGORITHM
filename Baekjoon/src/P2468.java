import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2468 {
    static int[][] map;
    static boolean[][] water;
    static boolean[][] visited;
    static int n;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    // 물에 잠긴 영역
    public static int flood(int i){
        visited = new boolean[n][n];
        int count = 0;

        for (int y = 0; y < n; y++){
            for (int x = 0; x < n; x++){
                if (map[y][x] <= i){
                    water[y][x] = true;
                }
            }
        }

        for (int y = 0; y < n; y++){
            for (int x = 0; x < n; x++){
                // 물에 안잠기고, 방문을 안한 영역 실행
                if (!water[y][x] && !visited[y][x]){
                    safety(x, y);
                    count++;
                }
            }
        }

        return count;
    }

    // 안전한 영역
    public static void safety(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[1];
            int cy = current[0];

            for (int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !water[ny][nx] && !visited[ny][nx]){
                    queue.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result;
        int MAX = 0;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        water = new boolean[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 침수 0 ~ 100
        for (int i = 0; i <= 100; i++){
            result = flood(i);
            if (MAX < result){
                MAX = result;
            }
        }

        System.out.println(MAX);
    }
}
