using System;
using System.Collections.Generic;

class Solution {
    public int solution(int[,] maps) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int n = maps.GetLength(0);
        int m = maps.GetLength(1);

        Queue<(int, int, int)> q = new Queue<(int, int, int)>();

        q.Enqueue((0, 0, 1));
        maps[0, 0] = 0;

        while(q.Count > 0){
            (int x, int y, int dist) = q.Dequeue();

            if(x == n - 1 && y == m - 1){
                return dist;
            }

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx, ny] == 1){
                    q.Enqueue((nx, ny, dist + 1));
                    maps[nx, ny] = 0;
                }
            }
        }

        return -1;
    }
}