import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] sides = new int[3];

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 3; i++) {
                sides[i] = Integer.parseInt(st.nextToken());
            }

            if (sides[0] == 0 && sides[1] == 0 && sides[2] == 0 ) {
                return;
            }

            Arrays.sort(sides);

            if (sides[2] >= (sides[1] + sides[0])) {
                System.out.println("Invalid");
            } else if (sides[2] == sides[1] && sides[1] == sides[0]) {
                System.out.println("Equilateral");
            } else if (sides[2] == sides[1] || sides[1] == sides[0] || sides[0] == sides[2]) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
    }
}
