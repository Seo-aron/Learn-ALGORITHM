import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P1261 {
    static int n;
    static int m;
    static int[][] map;
    static int[][] count;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void bfs(){
        Deque<Integer> dyDeque = new LinkedList<>();
        Deque<Integer> dxDeque = new LinkedList<>();
        dyDeque.offer(0);
        dxDeque.offer(0);

        while (!dyDeque.isEmpty()){
            int y = dyDeque.poll();
            int x = dxDeque.poll();

            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m){
                    if (count[ny][nx] == -1 || count[ny][nx] > count[y][x] + map[ny][nx]){
                        if (map[ny][nx] == 0) {
                            dyDeque.addFirst(ny);
                            dxDeque.addFirst(nx);
                            count[ny][nx] = count[y][x];
                        } else {
                            dyDeque.addLast(ny);
                            dxDeque.addLast(nx);
                            count[ny][nx] = count[y][x] + 1;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        count = new int[m][n];

        for (int y = 0; y < m; y++){
            String line = br.readLine();
            for (int x = 0; x < n; x++){
                map[y][x] = line.charAt(x) - '0';
            }
        }

        for (int y = 0; y < m; y++){
            for (int x = 0; x < n; x++){
                count[y][x] = -1;
            }
        }

        count[0][0] = 0;

        bfs();

        System.out.println(count[m-1][n-1]);
    }
}
