import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int size;
	static int[][] field;
	static HashMap<Integer, String> hm;
	static int[] dy = {0, 1, 0, -1};	// 우, 하, 좌, 상
	static int[] dx = {1, 0, -1, 0};
	
	public static void snakeSimul() {
		int time = 0;
		int dir = 0;	// 오른쪽
		
		LinkedList<int[]> snake = new LinkedList<>();
		HashSet<String> body = new HashSet<>();
		
		snake.add(new int[] {1, 1});
		body.add("1,1");
		
		while(true) {
			time++;
			
			int[] head = snake.peekFirst();
			int ny = head[0] + dy[dir];
			int nx = head[1] + dx[dir];
			
			if(ny <= 0 || ny > size || nx <= 0 || nx > size || body.contains(ny + "," + nx)) break;
			
			snake.addFirst(new int[]{ny, nx});
			body.add(ny + "," + nx);
			
			// 사과 유무
			if (field[ny][nx] == 1) {
				field[ny][nx] = 0;
			} else {
				int[] tail = snake.removeLast();
				body.remove(tail[0] + "," + tail[1]);
			}
			
			// 시간에 따른 방향 전환
			if(hm.containsKey(time)) {
				String turn = hm.get(time);
				if(turn.equals("L")) {
					// 현재 방향기준 왼쪽
					dir = (dir + 3) % 4;
				} else {
					dir = (dir + 1) % 4;
				}
			}
		}
		
		System.out.println(time);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		size = Integer.parseInt(br.readLine());
		int apple = Integer.parseInt(br.readLine());
		
		field = new int[size + 1][size + 1];
		
		for (int i = 0; i < apple; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			field[y][x] = 1;
		}
		
		int change = Integer.parseInt(br.readLine());
		hm = new HashMap<>();
		
		for (int i = 0; i < change; i++) {
			st = new StringTokenizer(br.readLine());
			int sec = Integer.parseInt(st.nextToken());
			String DL = st.nextToken();
			
			hm.put(sec, DL);
		}
		
		snakeSimul();
	}
}
