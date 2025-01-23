import java.util.Scanner;

public class P2292 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int layer = 1;
        int range = 1;

        while(num > range){
            range = range + (layer * 6);
            layer++;
        }

        System.out.println(layer);
    }
}
