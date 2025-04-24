import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2589 {
    static int y;
    static int x;
    static char[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static int treasure(int sy, int sx){
        int ans = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sy, sx, 0});
        visited[sy][sx] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cy = current[0];
            int cx = current[1];
            int count = current[2];

            if (ans < count) ans = count;

            for (int i = 0; i < 4; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny >= 0 && nx >= 0 && ny < y && nx < x && map[ny][nx] == 'L' && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.offer(new int[]{ny, nx, count+1});
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int result = 0;

        map = new char[y][x];

        for (int i = 0; i < y; i++){
            String line = br.readLine();
            for (int j = 0; j < x; j++){
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < y; i++){
            for (int j = 0; j < x; j++){
                if(map[i][j] == 'L') {
                    visited = new boolean[y][x];
                    int temp = treasure(i, j);

                    if (temp > result) {
                        result = temp;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
