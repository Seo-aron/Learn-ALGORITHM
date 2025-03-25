import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P11000 {
    public static void classCount(int[][] time, int lesson){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < lesson; i++){
            if (!pq.isEmpty() && pq.peek() <= time[i][0]){
                pq.poll();
            }
            pq.offer(time[i][1]);
        }

        System.out.println(pq.size());
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lesson = Integer.parseInt(br.readLine());
        int[][] time = new int[lesson][2];

        for (int i = 0; i < lesson; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        classCount(time, lesson);
    }
}
