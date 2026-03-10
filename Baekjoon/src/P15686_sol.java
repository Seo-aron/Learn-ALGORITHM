import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P15686_sol {
    static int n, m;
    static List<Point> houses = new ArrayList<>();
    static List<Point> chickens = new ArrayList<>();
    static boolean[] open; // 어떤 치킨집을 살릴지 선택 여부
    static int minCityChickenDist = Integer.MAX_VALUE;

    static class Point {
        int y, x;
        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 1. 입력받으며 좌표 리스트 미리 생성 (field 배열은 필요 없음)
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) houses.add(new Point(i, j));
                else if (val == 2) chickens.add(new Point(i, j));
            }
        }

        open = new boolean[chickens.size()];

        // 2. 백트래킹으로 치킨집 조합 구하기 시작
        dfs(0, 0);

        System.out.println(minCityChickenDist);
    }

    /**
     * @param start 탐색 시작 인덱스 (조합을 위해 필요)
     * @param cnt   현재까지 선택된 치킨집 개수
     */
    static void dfs(int start, int cnt) {
        // M개의 치킨집을 모두 골랐을 때
        if (cnt == m) {
            calculateCityChickenDistance();
            return;
        }

        // 치킨집 조합 뽑기 (Backtracking)
        for (int i = start; i < chickens.size(); i++) {
            open[i] = true;
            dfs(i + 1, cnt + 1);
            open[i] = false; // 원상 복구
        }
    }

    // 3. 현재 선택된 치킨집들을 기준으로 도시의 치킨 거리 계산
    static void calculateCityChickenDistance() {
        int totalDist = 0;

        for (Point house : houses) {
            int minHouseDist = Integer.MAX_VALUE;

            // 각 집마다 "선택된 치킨집" 중 가장 가까운 곳 찾기
            for (int i = 0; i < chickens.size(); i++) {
                if (open[i]) {
                    int d = Math.abs(house.y - chickens.get(i).y) + Math.abs(house.x - chickens.get(i).x);
                    minHouseDist = Math.min(minHouseDist, d);
                }
            }
            totalDist += minHouseDist;

            // 최적화: 계산 중에 이미 현재 최솟값을 넘었다면 중단 (Pruning)
            if (totalDist >= minCityChickenDist) return;
        }

        minCityChickenDist = Math.min(minCityChickenDist, totalDist);
    }
}