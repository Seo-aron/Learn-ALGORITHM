import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7569 {
    static int row;
    static int col;
    static int layer;
    // 상 하 좌 우 위 아래
    static int[] dx = {0, 0, -1, 1, 0 ,0};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void bfs(int[][][] field, int l, int c, int r){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{l, c, r});

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[2];
            int cy = current[1];
            int cz = current[0];

            for (int i = 0; i < 6; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nz = cz + dz[i];

                if (nx >= 0 && nx < row && ny >= 0 && ny < col && nz >= 0 && nz < layer){
                    if (field[nz][ny][nx] == 0){
                        field[nz][ny][nx] = field[cz][cy][cx] + 1;
                        queue.offer(new int[]{nz, ny, nx});
                    } else if (field[nz][ny][nx] > field[cz][cy][cx] + 1){
                        field[nz][ny][nx] = field[cz][cy][cx] + 1;
                        queue.offer(new int[]{nz, ny, nx});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        layer = Integer.parseInt(st.nextToken());
        int[][][] field = new int[layer][col][row];

        for (int l = 0; l < layer; l++){
            for (int c = 0; c < col; c++){
                st = new StringTokenizer(br.readLine());
                for (int r = 0; r < row; r++){
                    field[l][c][r] = Integer.parseInt(st.nextToken());
                }
            }
        }

        for (int l = 0; l < layer; l++){
            for (int c = 0; c < col; c++){
                for (int r = 0; r < row; r++){
                    if (field[l][c][r] == 1){
                        bfs(field, l, c, r);
                    }
                }
            }
        }

        int max = 1;

        for (int l = 0; l < layer; l++){
            for (int c = 0; c < col; c++){
                for (int r = 0; r < row; r++){
                    if (field[l][c][r] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    if (max < field[l][c][r]) max = field[l][c][r];
                }
            }
        }

        System.out.println(max - 1);
    }
}
