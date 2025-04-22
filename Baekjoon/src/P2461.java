import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P2461 {
    static class Node implements Comparable<Node> {
        int value;
        int classNum;
        int studentNum;

        public Node (int value, int classNum, int studentNum) {
            this.value = value;
            this.classNum = classNum;
            this.studentNum = studentNum;
        }

        @Override
        public int compareTo(Node o) {
            // 오름차순
            return this.value - o.value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int classCount = Integer.parseInt(st.nextToken());
        int studentCount = Integer.parseInt(st.nextToken());
        int[][] arr = new int[classCount][studentCount];

        for (int i = 0; i < classCount; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < studentCount; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr[i]);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int max = 0;

        for (int i = 0; i < classCount; i++) {
            int val = arr[i][0];
            pq.offer(new Node(val, i, 0));
            max = Math.max(max, val);
        }

        int result = Integer.MAX_VALUE;

        while (true){
            Node now = pq.poll();
            int min = now.value;

            result = Math.min(max - min, result);

            if (now.studentNum + 1 >= studentCount) break;

            int nextStudentNum = now.studentNum + 1;
            int nextValue = arr[now.classNum][nextStudentNum];
            pq.offer(new Node(nextValue, now.classNum, nextStudentNum));

            max = Math.max(max, nextValue);
        }
        System.out.println(result);
    }
}
