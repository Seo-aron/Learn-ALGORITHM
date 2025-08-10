import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P1021 {
    static int result = 0;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        int[] arr = new int[cnt];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            dq.offer(i+1);
        }

        for (int i = 0; i < arr.length; i++) {
            while (true) {
                if (arr[i] == dq.getFirst()) {
                    isPoll(dq);
                    break;
                } else {
                    int index = getIndex(dq, arr, i);
                    //Left
                    if (index > (dq.size() / 2)) {
                        moveRight(dq, arr[i]);
                    } else {
                        moveLeft(dq, arr[i]);
                    }
                }
            }
        }

        System.out.println(result);
    }

    private static int getIndex(Deque<Integer> dq, int[] arr, int i) {
        int pos = 0;
        for (Integer index : dq) {
            if (arr[i] == index) {
                return pos;
            }
            pos++;
        }
        return -1;
    }

    private static void isPoll(Deque<Integer> dq) {
        if (!dq.isEmpty()) {
            dq.poll();
        }
    }

    private static void moveRight(Deque<Integer> dq, int target) {

        while (true) {
            if (target == dq.getFirst()) {
                return;
            }
            else {
                int num = dq.pollLast();
                dq.offerFirst(num);
                result++;
            }
        }
    }

    private static void moveLeft(Deque<Integer> dq, int target) {

        while (true) {
            if (target == dq.getFirst()) {
                return;
            }
            else {
                int num = dq.pollFirst();
                dq.offerLast(num);
                result++;
            }
        }
    }
}
