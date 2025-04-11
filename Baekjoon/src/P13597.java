import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class P13597 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int subin = sc.nextInt();
        int sister = sc.nextInt();

        if (subin == sister) {
            System.out.println(0);
            return;
        }

        int[] time = new int[100001];

        Arrays.fill(time, Integer.MAX_VALUE);
        time[subin] = 0;

        Deque<Integer> deque = new LinkedList<>();
        deque.add(subin);

        while (!deque.isEmpty()){
            int distance = deque.poll();

            // 순간이동
            if (distance * 2 <= 100000 && time[distance * 2] > time[distance]){
                deque.addFirst(distance * 2);
                time[distance * 2] = time[distance];
            }
            // 1칸 전진
            if (distance + 1 <= 100000 && time[distance + 1] > time[distance] + 1){
                deque.addLast(distance + 1);
                time[distance + 1] = time[distance] + 1;
            }
            // 1칸 후진
            if (distance - 1 >= 0 && time[distance - 1] > time[distance] + 1){
                deque.addLast(distance - 1);
                time[distance - 1] = time[distance] + 1;
            }
        }

        System.out.println(time[sister]);
    }
}
