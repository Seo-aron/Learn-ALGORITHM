import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14500 {
	static int n;
	static int m;
	static int[][] table;
	static boolean[][] visited;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int max = 0;
	
	static void checkExtra(int y, int x) {
		int sum = 0;
		// ㅗ
		if(y-1 >= 0 && x-1 >= 0 && x+1 < m) {
			sum = table[y][x] + table[y-1][x] + table[y][x-1] + table[y][x+1];
			max = Math.max(max, sum);
		}
		// ㅜ
		if(y+1 < n && x-1 >= 0 && x+1 < m) {
			sum = table[y][x] + table[y+1][x] + table[y][x-1] + table[y][x+1];
			max = Math.max(max, sum);
		}
		// ㅓ
		if(x-1 >= 0 && y-1 >= 0 && y+1 < n) {
			sum = table[y][x] + table[y-1][x] + table[y][x-1] + table[y+1][x];
			max = Math.max(max, sum);
		}
		// ㅏ
		if(y-1 >= 0 && y+1 < n && x+1 < m) {
			sum = table[y][x] + table[y-1][x] + table[y+1][x] + table[y][x+1];
			max = Math.max(max, sum);
		}
	}
	
	static void dfs(int y, int x, int cnt, int sum) {
		if(cnt == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
			if (visited[ny][nx]) continue;
			
			visited[ny][nx] = true;
			dfs(ny, nx, cnt+1, sum + table[ny][nx]);
			visited[ny][nx] = false;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		table = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				dfs(i, j, 0, 0);
				checkExtra(i, j);
			}
		}
		
		System.out.println(max);
	}
}
