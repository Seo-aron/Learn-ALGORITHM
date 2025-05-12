import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int y;
	static int x;
	static int dice_y;
	static int dice_x;
	static int count;
	static int[][] field;
	static int[] dice;
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {1, -1, 0, 0};
	
	public static void diceSimul(int dir) {
		int ny = dice_y + dy[dir - 1];
		int nx = dice_x + dx[dir - 1];
		
		if (ny < 0 || nx < 0 || ny >= y || nx >= x) return;
		
		dice_y = ny;
		dice_x = nx;
		
		// [1] = 바닥면, [2] = 북쪽면, [3] = 윗면, [4] = 남쪽면, [5] = 동쪽면, [6] = 서쪽면
		switch(dir) {
			case 1:
				// 주사위를 동쪽으로 이동
				if (field[ny][nx] != 0) {
					dice[5] = dice[3];
					dice[3] = dice[6];
					dice[6] = dice[1];
					dice[1] = field[ny][nx];
					field[ny][nx] = 0;
				} else if (field[ny][nx] == 0) {
					int temp = dice[5];
					dice[5] = dice[3];
					dice[3] = dice[6];
					dice[6] = dice[1];
					dice[1] = temp;
					field[ny][nx] = dice[1];
				}
				break;
			case 2:
				// 주사위를 서쪽으로 이동
				if (field[ny][nx] != 0) {
					dice[6] = dice[3];
					dice[3] = dice[5];
					dice[5] = dice[1];
					dice[1] = field[ny][nx];
					field[ny][nx] = 0;
				} else if (field[ny][nx] == 0) {
					int temp = dice[6];
					dice[6] = dice[3];
					dice[3] = dice[5];
					dice[5] = dice[1];
					dice[1] = temp;
					field[ny][nx] = dice[1];
				}
				break;
			case 3:
				// 주사위를 북쪽으로 이동
				if (field[ny][nx] != 0) {
					dice[2] = dice[3];
					dice[3] = dice[4];
					dice[4] = dice[1];
					dice[1] = field[ny][nx];
					field[ny][nx] = 0;
				} else if (field[ny][nx] == 0) {
					int temp = dice[2];
					dice[2] = dice[3];
					dice[3] = dice[4];
					dice[4] = dice[1];
					dice[1] = temp;
					field[ny][nx] = dice[1];
				}
				break;
			case 4:
				// 주사위를 남쪽으로 이동
				if (field[ny][nx] != 0) {
					dice[4] = dice[3];
					dice[3] = dice[2];
					dice[2] = dice[1];
					dice[1] = field[ny][nx];
					field[ny][nx] = 0;
				} else if (field[ny][nx] == 0) {
					int temp = dice[4];
					dice[4] = dice[3];
					dice[3] = dice[2];
					dice[2] = dice[1];
					dice[1] = temp;
					field[ny][nx] = dice[1];
				}
				break;
		}
		System.out.println(dice[3]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		dice_y = Integer.parseInt(st.nextToken());
		dice_x = Integer.parseInt(st.nextToken());
		count = Integer.parseInt(st.nextToken());
		field = new int[y][x];
		dice = new int[7];
		
		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < x; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < count; i++) {
			// 1 = 동, 2 = 서, 3 = 북, 4 = 남
			int dir = Integer.parseInt(st.nextToken());
			diceSimul(dir);
		}
	}
}
