import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P14502 {
    static int n;
    static int m;
    static int[][] map;
    static int[][] copyMap;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int result = 0;

    public static void virus(int y, int x){
        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n && copyMap[ny][nx] == 0){
                copyMap[ny][nx] = 2;
                virus(ny, nx);
            }
        }
    }

    public static void simul(List<int[]> empty, int[] select){
        int tempResult = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
               copyMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < 3; i++){
            int[] wall = empty.get(select[i]);
            copyMap[wall[0]][wall[1]] = 1;
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (copyMap[i][j] == 2) {
                    virus(i, j);
                }
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (copyMap[i][j] == 0){
                    tempResult++;
                }
            }
        }

        result = Math.max(result, tempResult);
    }

    public static void comb(List<int[]> empty, int[] select, int start, int count){
        if (count == 3){
            simul(empty, select);
            return;
        }

        for (int i = start; i < empty.size(); i++){
            select[count] = i;
            comb(empty, select, i + 1, count + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        copyMap = new int[n][m];
        List<int[]> empty = new ArrayList<>();

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (map[i][j] == 0) empty.add(new int[]{i, j});
            }
        }

        comb(empty, new int[3], 0, 0);

        System.out.println(result);
    }
}
