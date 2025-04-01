import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10026 {
    static int size;
    static char[][] field;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void dfs(int y, int x, char color) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < size && ny >= 0 && ny < size){
                if (!visited[ny][nx] && field[ny][nx] == color){
                    dfs(ny, nx, color);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        field = new char [size][size];
        visited = new boolean[size][size];

        for (int i = 0; i < size; i++){
            String line = br.readLine();
            for (int j = 0; j < size; j++){
                field[i][j] = line.charAt(j);
            }
        }

        int nCount = 0;
        int bCount = 0;

        // 정상인
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (!visited[i][j]){
                    dfs(i, j, field[i][j]);
                    nCount++;
                }
            }
        }

        visited = new boolean[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (field[i][j] == 'G') field[i][j] = 'R';
            }
        }

        // 적록생맹
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (!visited[i][j]){
                    dfs(i, j, field[i][j]);
                    bCount++;
                }
            }
        }

        System.out.println(nCount + " " + bCount);
    }
}
