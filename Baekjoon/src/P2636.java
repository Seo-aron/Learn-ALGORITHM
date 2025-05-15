import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2636 {
	static int y;
	static int x;
	static int[][] field;
	static boolean[][] visited;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static int cheese = 0;
	
	public static void cheeseSimul() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0, 0});
		visited = new boolean[y][x];
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int cy = current[0];
			int cx = current[1];
			
			for (int i = 0; i < 4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];
				
				if (ny < 0 || nx < 0 || ny >= y || nx >= x || visited[ny][nx]) continue;
				
				if(field[ny][nx] == 1) {
					visited[ny][nx] = true;
					field[ny][nx] = 0;
				}
				else if (field[ny][nx] == 0) {
					visited[ny][nx] = true;
					queue.offer(new int[] {ny, nx});
				}
			}
		}
	}
	
	public static boolean isChecked() {
		boolean flag = true;
		int currentCheese = 0;
		
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				// 치즈가 남아있다면 F 반환
				if (field[i][j] == 1) {
					flag = false;
					currentCheese++;
				}
			}
		}
		
		if (currentCheese != 0) cheese = currentCheese;
		
		return flag;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		int time = 0;
		
		field = new int[y][x];
		
		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < x; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			if (!isChecked()) {
				// 치즈가 남아있다면
				cheeseSimul();
				time++;
			} else {
				// 남은 치즈가 없을 때
				System.out.println(time);
				System.out.println(cheese);
				return;
			}
		}
	}
}
