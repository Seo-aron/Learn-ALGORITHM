import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P16234 {
    static int size;
    static int min;
    static int max;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean isMove;

    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static void moveSimul() {
        int day = 0;

        while (true) {
            isMove = false;
            visited = new boolean[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (!visited[i][j]) bfs(i, j);
                }
            }

            if (!isMove) break;
            day++;
        }

        System.out.println(day);
    }

    private static void bfs(int sy, int sx) {
        Queue<Point> queue = new LinkedList<>();
        List<Point> union = new ArrayList<>();
        queue.offer(new Point(sy, sx));
        union.add(new Point(sy, sx));
        visited[sy][sx] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int cy = current.y;
            int cx = current.x;

            for (int i=0; i<4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny >= 0 && ny < size && nx >= 0 && nx < size && !visited[ny][nx]) {
                    int diff = Math.abs(map[cy][cx] - map[ny][nx]);
                    if (diff >= min && diff <= max) {
                        visited[ny][nx] = true;
                        queue.offer(new Point(ny, nx));
                        union.add(new Point(ny, nx));
                    }
                }
            }
        }

        if (union.size() > 1) {
            isMove = true;
            applyAvr(union);
        }
    }

    private static void applyAvr(List<Point> union) {
        int avr = 0;

        for (Point p : union) {
            avr += map[p.y][p.x];
        }

        avr /= union.size();

        for (Point p : union) {
            map[p.y][p.x] = avr;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        min = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(st.nextToken());
        map = new int[size][size];

        for (int i=0; i<size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        moveSimul();
    }
}
