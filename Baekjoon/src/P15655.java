import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P15655 {
    static StringBuilder sb = new StringBuilder();
    private static void comb(int[] card, int draw, ArrayList<Integer> result, int start) {
        if (result.size() == draw){
            for (int i = 0; i < result.size(); i++){
                sb.append(result.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < card.length; i++){
            result.add(card[i]);
            comb(card, draw, result, i + 1);
            result.remove(result.size() - 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int draw = sc.nextInt();
        int[] card = new int[size];

        for (int i = 0; i < size; i++){
            card[i] = sc.nextInt();
        }
        Arrays.sort(card);

        comb(card, draw, new ArrayList<Integer>(), 0);

        System.out.print(sb);
    }
}
