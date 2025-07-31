import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class minNum implements Comparable<minNum>{
    int num;

    public minNum(int num) {
        this.num = num;
    }

    @Override
    public int compareTo(minNum o) {
        return this.num - o.num;
    }
}

public class P1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<minNum> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            if (m == 0) {
                if (pq.isEmpty()){
                    sb.append(0).append('\n');
                } else {
                    sb.append(pq.poll().num).append("\n");
                }
            } else {
                pq.offer(new minNum(m));
            }
        }

        System.out.println(sb);
    }
}
