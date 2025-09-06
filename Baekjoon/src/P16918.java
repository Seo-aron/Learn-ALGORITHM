import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * RxC크기 격자판
 * 비어있거나, 폭탄있음
 * 폭탄은 3초후 폭발 -> 빈칸됨
 * + 인접한 4칸 함께 파괴 + 연쇄X 그냥 폭탄도 파괴
 *
 * 1. 폭탄 설치
 * 2. 1초동안 아무것도 안함 (1초)
 * 3. 그 이후 1초동안 폭탄이 없는 칸에 폭탄을 전부 설치함 즉, 모든 칸이 폭탄이다 (2초)
 * 4. 그 이후 1초 = 처음 설치한 폭탄이 파괴되는 시점. 처음 설치한 폭탄 모두 폭발 (3초)
 * 5. 3번과 4번 반복
 *
 * -> 2초 설치, 3초 폭발, 4초 설치, 5초 폭발, 6초 설치, 7초 폭발, ....
 * nextSecond 수정, 시작할 때 0초->1초->2초 이 부분 잘 되었는지 확인해야함
 *
 * 빈칸은 .  폭탄은 o
 *
 * N초가 흐른 후 격자판 상태 출력
 *
 *
 */

public class P16918 {
    static int y, x, n;
    static int time = 0;
    static char[][] field;  //입출력
    static int[][] bomb;    //실제 구현
    static final int[] dy = {-1, 1, 0 ,0};
    static final int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        field = new char[y][x];
        bomb = new int[y][x];

        for (int i=0; i<y; i++) {
            String line = br.readLine();
            for (int j=0; j<x; j++) {
                field[i][j] = line.charAt(j);
            }
        }

        init();

        while (time < n) {
            nextSecond();
        }

        end();
    }

    static void nextSecond() {
        time++;

        if (time % 2 == 0) {
            for (int i=0; i<y; i++) {
                for (int j=0; j<x; j++) {
                    if (bomb[i][j] == -1) {
                        bomb[i][j] = 0;
                    } else {
                        bomb[i][j]++;
                    }
                }
            }
        }
        else {
            //폭탄 +1
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if (bomb[i][j] != -1) {
                        bomb[i][j]++;
                    }
                }
            }

            if (time >= 3) {
                boolean[][] destroy = new boolean[y][x];
                for (int i = 0; i < y; i++) {
                    for (int j = 0; j < x; j++) {
                        if (bomb[i][j] >= 3) {
                            destroy[i][j] = true;
                            for (int d=0; d<4; d++) {
                                int ny = i + dy[d];
                                int nx = j + dx[d];

                                if (ny < 0 || ny >= y || nx < 0 || nx >= x) continue;
                                destroy[ny][nx] = true;
                            }
                        }
                    }
                }
                for (int i = 0; i < y; i++) {
                    for (int j = 0; j < x; j++) {
                        if (destroy[i][j]) {
                            bomb[i][j] = -1;
                        }
                    }
                }
            }
        }
    }

    static void init() {
        for (int i=0; i<y; i++) {
            for (int j=0; j<x; j++) {
                if (field[i][j] == 'O') {
                    bomb[i][j] = 0;
                } else {
                    bomb[i][j] = -1;
                }
            }
        }
    }

    static void end() {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<y; i++) {
            for (int j=0; j<x; j++) {
                if (bomb[i][j] == -1) {
                    sb.append(".");
                } else {
                    sb.append("O");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}