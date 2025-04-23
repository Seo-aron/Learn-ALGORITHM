import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P2206 {
    static int y;
    static int x;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static class Node implements Comparable<Node> {
        int cy, cx, wall, count;

        public Node (int cy, int cx, int wall, int count) {
            this.cy = cy;
            this.cx = cx;
            this.wall = wall;
            this.count = count;
        }
        @Override
        public int compareTo(Node o) {
            return this.count - o.count;
        }
    }

    public static void bfs(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 1, 0, 1));
        visited[1][1][0] = true;

        while (!pq.isEmpty()){
            Node current = pq.poll();
            int cy = current.cy;
            int cx = current.cx;
            int wall = current.wall;
            int count = current.count;

            if (cy == y && cx == x) {
                System.out.println(count);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny >= 1 && nx >= 1 && ny <= y && nx <= x) {
                    // 이미 벽을 부쉈는데 또 벽을 만난 경우
                    if (map[ny][nx] == 1 && wall == 1) continue;
                    else {
                        // 아직 벽을 안부순 상태에서 벽을 만난 경우
                        // 벽이 있는곳은 무조건 벽을 부수고 들어가야하니 visited[?][?][1] 이여야 됨
                        if (map[ny][nx] == 1 && wall == 0 && !visited[ny][nx][1]){
                            pq.offer(new Node(ny, nx, wall + 1, count + 1));
                            visited[ny][nx][1] = true;
                        }
                        // 길을 가는 경우 (벽을 부쉈든 안부쉈든 상관없음)
                        // 부순적이 있다면 visited[?][?][1]이 고정 아니라면 [0]이 고정 된 상태에서 방문 여부 체크
                        else if(map[ny][nx] == 0 && !visited[ny][nx][wall]){
                            pq.offer(new Node(ny, nx, wall, count + 1));
                            visited[ny][nx][wall] = true;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        map = new int[y + 1][x + 1];
        visited = new boolean[y + 1][x + 1][2];

        for (int i = 1; i <= y; i++){
            String line = br.readLine().trim();
            for (int j = 1; j <= x; j++){
                map[i][j] = line.charAt(j - 1) - '0';
            }
        }

        bfs();
    }
}
