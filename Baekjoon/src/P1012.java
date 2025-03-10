import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1012 {
    static int[][] field;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0 ,0};
    static int width;
    static int length;

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[1];
            int cy = current[0];

            for (int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < width && ny < length){
                    if (field[ny][nx] == 1 && !visited[ny][nx]){
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            length = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            int result = 0;

            field = new int[length][width];
            visited = new boolean[length][width];

            for (int j = 0; j < count; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                field[b][a] = 1;
            }

            for (int y = 0; y < length; y++){
                for (int x = 0; x < width; x++){
                    if (!visited[y][x] && field[y][x] == 1){
                        bfs(x, y);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
