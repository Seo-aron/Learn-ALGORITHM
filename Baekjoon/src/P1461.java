import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int book = Integer.parseInt(st.nextToken());
        int carry = Integer.parseInt(st.nextToken());
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        int ans = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < book; i++){
            int num = Integer.parseInt(st.nextToken());
            if (num < 0) {
                negatives.add(num);
            } else {
                positives.add(num);
            }
        }

        Collections.sort(positives);
        Collections.reverse(positives);

        Collections.sort(negatives);

        if (!positives.isEmpty()) max = positives.get(0);
        if (!negatives.isEmpty()) max = Math.max(max, Math.abs(negatives.get(0)));

        List<Integer> currentCarry = new ArrayList<>();
        while (!positives.isEmpty()){
            currentCarry.add(positives.get(0));
            positives.remove(0);

            if (currentCarry.size() == carry) {
                ans += currentCarry.get(0) * 2;
                currentCarry = new ArrayList<>();
            }
        }
        if (!currentCarry.isEmpty()) {
            ans += currentCarry.get(0) * 2;
            currentCarry = new ArrayList<>();
        }

        while (!negatives.isEmpty()){
            currentCarry.add(negatives.get(0));
            negatives.remove(0);

            if (currentCarry.size() == carry) {
                ans += Math.abs(currentCarry.get(0) * 2);
                currentCarry = new ArrayList<>();
            }
        }
        if (!currentCarry.isEmpty()) {
            ans += Math.abs(currentCarry.get(0) * 2);
        }

        ans = ans - max;

        System.out.println(ans);
    }
}
