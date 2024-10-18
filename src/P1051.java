import java.util.*;
import java.io.*;

public class P1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 열 번호
        int M = Integer.parseInt(st.nextToken());   // 행 번호
        int[][] map = new int[N][M];                // 사각형 생성

        // 사각형 만들기
        for (int i = 0; i < N; i++) {
            // 행의 개수에 맞게 숫자를 입력 받음
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                // 위에 입력받은걸 각 행에 뿌려줌
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int min = Math.min(N, M);   // 정사각형의 최대 길이

        // 4개의 모서리 값이 같은 정사각형 크기 구하기
        while(min > 1){
            for(int i = 0; i <= N - min; i++){
                for(int j = 0; j <= M - min; j++){
                    int square = map[i][j];
                    if(square == map[i][j+min-1] && square == map[i+min-1][j] && square == map[i+min-1][j+min-1]){
                        System.out.println(min * min);
                        return;
                    }
                }
            }
            min--;
        }
        System.out.println(min * min);
    }
}
