import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2667 {
    static int size;
    static int[][] field;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0 ,0};

    public static int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        int homeCount = 1;
        visited[y][x] = true;
        queue.add(new int[]{y, x});

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[1];
            int cy = current[0];

            for (int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < size && ny < size){
                    if(field[ny][nx] == 1 && !visited[ny][nx]){
                        queue.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                        homeCount++;
                    }
                }
            }
        }
        return homeCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        int complexCount = 0;
        List<Integer> homeCount = new ArrayList<>();

        field = new int[size][size];
        visited = new boolean[size][size];

        for (int i = 0; i < size; i++){
            String line = br.readLine();
            for (int j = 0; j < size; j++){
                field[i][j] = line.charAt(j) - '0';
            }
        }

        for (int y = 0; y < size; y++){
            for (int x = 0; x < size; x++){
                if (!visited[y][x] && field[y][x] == 1){
                    homeCount.add(bfs(x, y));
                    complexCount++;
                }
            }
        }
        System.out.println(complexCount);

        Collections.sort(homeCount);
        for (int count : homeCount) {
            System.out.println(count);
        }
    }
}
