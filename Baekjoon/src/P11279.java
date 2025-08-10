import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class maxArr implements Comparable<maxArr>{
    int num;

    maxArr(int num){
        this.num = num;
    }

    @Override
    public int compareTo(maxArr o) {
        return o.num - num;
    }
}

public class P11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<maxArr> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        int n =  Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            if (m == 0) {
                if (!pq.isEmpty()) {
                    sb.append(pq.poll().num).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else {
                pq.offer(new maxArr(m));
            }
        }

        System.out.println(sb);
    }
}
