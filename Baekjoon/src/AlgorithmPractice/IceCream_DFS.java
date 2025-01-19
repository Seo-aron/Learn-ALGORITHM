package AlgorithmPractice;

import java.util.Scanner;

public class IceCream_DFS {
    public static int n, m;
    public static int[][] graph = new int [1000][1000];

    public static boolean dfs(int x, int y){
        // 좌표가 범위 밖이면 종료
        if(x <= -1 || x >= n || y <= -1 || y >= m){
            return false;
        }

        // 현재 노드를 아직 방문하지 않았다면
        if(graph[x][y] == 0){
            graph[x][y] = 1;
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();

        // ex) 11011 이런 값 입력 받는 반복문
        for(int i = 0; i < n; i++){
            String str = scanner.nextLine();
            for (int j = 0; j < m; j++){
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(dfs(i, j)){
                    result += 1;
                }
            }
        }

        System.out.println(result);
    }
}
