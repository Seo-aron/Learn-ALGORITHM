import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 상어에 대한 정보
class Shark {
    int y, x;
    int size = 2;
    int time = 0;
    int eatstack = 0;

    public Shark(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public void eat(Fish fish) {
        this.y = fish.y;
        this.x = fish.x;
        this.time += fish.dist;
        this.eatstack++;
        if (this.size == this.eatstack) {
            this.size++;
            this.eatstack = 0;
        }
    }
}

// 물고기에 대한 우선순위
class Fish implements Comparable<Fish>{
    // 1. 거리 2. 행 3. 열
    int y, x, dist;

    public Fish(int y, int x, int dist) {
        this.y = y;
        this.x = x;
        this.dist = dist;
    }

    @Override
    public int compareTo(Fish other) {
        if (this.dist != other.dist) return this.dist - other.dist;
        if (this.y != other.y) return this.y - other.y;
        return this.x - other.x;
    }
}

public class P16236 {
    static int n;
    static int[][] field;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void simul(Shark shark){
        PriorityQueue<Fish> pq = new PriorityQueue<>();
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        // 상어의 위치 ( y, x, 이동거리(=시간) )
        queue.offer(new int[] {shark.y, shark.x, 0});
        visited[shark.y][shark.x] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int y = now[0];
            int x = now[1];
            int dist = now[2];

            for (int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && nx >= 0 && ny < n && nx < n && !visited[ny][nx] && shark.size >= field[ny][nx]) {
                    queue.offer(new int[] {ny, nx, dist + 1});
                    visited[ny][nx] = true;

                    if (shark.size > field[ny][nx] && field[ny][nx] > 0){
                        pq.offer(new Fish(ny, nx, dist + 1));
                    }
                }
            }
        }
        if (pq.isEmpty()) return;

        Fish target = pq.poll();
        shark.eat(target);
        field[target.y][target.x] = 0;
        simul(shark);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        field = new int[n][n];
        boolean flag = false;
        int babyX = 0;
        int babyY = 0;

        for (int y = 0; y < n; y++){
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x ++){
                field[y][x] = Integer.parseInt(st.nextToken());
                if (field[y][x] == 9) {
                    babyY = y;
                    babyX = x;
                }
                if (field[y][x] != 0 && field[y][x] != 9) flag = true;
            }
        }
        field[babyY][babyX] = 0;

        // 물고기가 없을 때
        if (!flag) {
            System.out.println(0);
            return;
        }

        Shark shark = new Shark(babyY, babyX);
        simul(shark);

        System.out.println(shark.time);
    }
}
