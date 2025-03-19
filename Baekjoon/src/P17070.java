import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P17070 {
    static int size;
    static int[][] map;
    static int count = 0;

    public static void pipe(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 2, 0});  // {y, x, 파이프가 놓인 상태 : 0 가로, 1 세로, 2 대각}

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            int direction = now[2];
            int cx = now[1];
            int cy = now[0];
            int nx = cx + 1;
            int ny = cy + 1;

            if (cx == size && cy == size) {
                count++;
                continue;
            }

            if (nx <= size && ny <= size && map[cy][nx] == 0 && map[ny][cx] == 0 && map[ny][nx] == 0){
                queue.add(new int[]{cy+1, cx+1, 2});
            }
            if ((direction == 0 || direction == 2) && nx <= size && map[cy][nx] == 0){
                queue.add(new int[]{cy, cx+1, 0});
            }
            if ((direction == 1 || direction == 2) && ny <= size && map[ny][cx] == 0){
                queue.add(new int[]{cy+1, cx, 1});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        map = new int[size+1][size+1];

        StringTokenizer st;
        for (int i = 1; i <= size; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= size; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (map[1][3] == 1){
            System.out.println(0);
            return;
        }

        pipe();

        System.out.println(count);
    }
}
