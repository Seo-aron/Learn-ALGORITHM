import java.io.*;
import java.util.*;

class Rupee implements Comparable<Rupee> {
    int x, y, cost;

    public Rupee(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Rupee o) {
        return this.cost - o.cost;
    }
}


public class P4485 {
	static int INF = Integer.MAX_VALUE;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	static int jelda(int[][] map, int[][] dist, int n) {
		PriorityQueue<Rupee> pq = new PriorityQueue<>();
		pq.offer(new Rupee(0, 0, map[0][0]));
		while(!pq.isEmpty()) {
			Rupee current = pq.poll();
			int cy = current.y;
			int cx = current.x;
			int cost = current.cost;
			
			if(dist[cy][cx] < cost) continue;
			
			for(int i=0; i<4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];
				
				if(ny<0 || nx<0 || ny>=n || nx>=n) continue;
				
				int ncost = cost + map[ny][nx];
				
				if(dist[ny][nx] > ncost) {
					dist[ny][nx] = ncost;
					pq.offer(new Rupee(nx, ny, ncost));
				}
			}
		}
		
		return dist[n-1][n-1];
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) return;
			cnt++;
			
			int[][] map = new int[n][n];
			int[][] dist = new int[n][n];
			
			for (int i = 0; i < n; i++) {
			    Arrays.fill(dist[i], INF);
			}
			
			for (int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dist[0][0] = map[0][0];
			
			int ans = jelda(map, dist, n);
			
			System.out.println("Problem " + cnt +": " + ans);
		}
	}
}
