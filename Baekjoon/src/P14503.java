import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14503 {
    static int y, x;
    static int[][] field;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void robovac(int start_y, int start_x, int start_head){
        int ans = 1;
        visited[start_y][start_x] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start_y, start_x, start_head});

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int cy = current[0];
            int cx = current[1];
            int head = current[2];
            boolean flag = false;

            for (int i = 0; i < 4; i++){
                head = (head + 3) % 4;
                int ny = cy + dy[head];
                int nx = cx + dx[head];

                if (ny >= 0 && nx >= 0 && ny < y && nx < x) {
                    // 청소 가능한 빈 칸이 있는 경우
                    if (!visited[ny][nx] && field[ny][nx] == 0) {
                        visited[ny][nx] = true;
                        queue.offer(new int[]{ny, nx, head});
                        ans++;
                        flag = true;
                        break;
                    }
                }
            }
            // 청소할 빈 칸이 없는 경우
            if (!flag) {
                int back = (head + 2) % 4;
                int by = cy + dy[back];
                int bx = cx + dx[back];

                if (field[by][bx] == 0) {
                    queue.offer(new int[]{by, bx, head});
                } else {
                    System.out.println(ans);
                    return;
                }
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        field = new int[y][x];
        visited = new boolean[y][x];

        st = new StringTokenizer(br.readLine());
        int robot_y = Integer.parseInt(st.nextToken());
        int robot_x = Integer.parseInt(st.nextToken());
        // 0 = 북, 1 = 동, 2 = 남, 3 = 서
        int head = Integer.parseInt(st.nextToken());

        for (int i = 0; i < y; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++){
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        robovac(robot_y, robot_x, head);
    }
}
