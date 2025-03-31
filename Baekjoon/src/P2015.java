import java.util.HashMap;
import java.util.Scanner;

public class P2015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        long sum = sc.nextLong();

        HashMap<Long, Integer> sumCount = new HashMap<>();
        sumCount.put(0L, 1);
        long count = 0;
        long prefixSum = 0;

        for (int i = 0; i < size; i++){
            prefixSum += sc.nextLong();

            if (sumCount.containsKey(prefixSum - sum)){
                count += sumCount.get(prefixSum - sum);
            }

            sumCount.put(prefixSum, sumCount.getOrDefault(prefixSum, 0) + 1);
        }

        System.out.println(count);
    }
}
