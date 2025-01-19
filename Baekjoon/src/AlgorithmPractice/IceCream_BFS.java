package AlgorithmPractice;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IceCream_BFS {
    public static int n, m;
    public static int[][] graph = new int[1000][1000];
    public static int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public static boolean bfs(int x, int y){
        if (graph[x][y] == 0){
            // 큐를 생성한 뒤 좌표를 추가하고 해당 좌표를 1로 처리해서 방문 표시함
            Queue<Point> q = new LinkedList<Point>();

            q.offer(new Point(x,y));
            graph[x][y] = 1;

            // queue 비울 때 까지 반복
            while(!q.isEmpty()){
                Point p = q.poll();
                int row = p.x;
                int col = p.y;

                for(int[] direction : directions){
                    int dx = direction[0];
                    int dy = direction[1];

                    if(row+dy >= 0 && row+dy <= n-1 && col+dx >= 0 && col+dx <= m-1){
                        if(graph[row+dy][col+dx] == 0){
                            q.offer(new Point(row+dy, col+dx));
                            graph[row+dy][col+dx] = 1;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++){
            String str = sc.nextLine();
            for (int j = 0; j < m; j++){
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(bfs(i, j)){
                    result += 1;
                }
            }
        }

        System.out.println(result);
        int x = 1;
    }
}
