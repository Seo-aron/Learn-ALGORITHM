import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P7576 {
    static int[][] tomato;
    static int m;
    static int n;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    private static void bfs(Queue<int[]> queue) {

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[1];
            int cy = current[0];

            for (int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    // 안익은 토마토가 붙어 있을 경우
                    if (tomato[ny][nx] == 0){
                        queue.add(new int[]{ny, nx});
                        tomato[ny][nx] = tomato[cy][cx] + 1;
                    }
                    else if(tomato[ny][nx] > tomato[cy][cx] + 1){
                        tomato[ny][nx] = tomato[cy][cx] + 1;
                    }
                    else if (tomato[ny][nx] == -1){
                        continue;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<int[]> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());    // 가로
        n = Integer.parseInt(st.nextToken());    // 세로
        tomato = new int[n][m];
        int result = 0;

        for (int y = 0; y < n; y++){
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++){
                tomato[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for (int y = 0; y < n; y++){
            for (int x = 0; x < m; x++){
                if (tomato[y][x] == 1){
                    queue.add(new int[]{y, x});
                }
            }
        }
        bfs(queue);

        // 출력
        boolean flag = true;
        for (int y = 0; y < n; y++){
            for (int x = 0; x < m; x++){
                if (tomato[y][x] == 0){
                    System.out.println(-1);
                    return;
                }
                if (tomato[y][x] != 1){
                    flag = false;
                }
                if (result < tomato[y][x]){
                    result = tomato[y][x];
                }
            }
        }

        if (flag) System.out.println(0);
        else System.out.println(result - 1);
    }
}
