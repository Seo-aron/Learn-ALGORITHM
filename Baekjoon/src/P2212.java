import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sensor = Integer.parseInt(br.readLine());
        int center = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sensors = new int[sensor];
        int[] diff = new int[sensor];

        for (int i = 0; i < sensor; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensors);
        arrayReverse(sensors);

        for (int i = 0; i < sensor-1; i++) {
            diff[i] = sensors[i] - sensors[i+1];
        }
        Arrays.sort(diff);

        minSum(center, sensor, diff);
    }

    private static void minSum(int center, int sensor, int[] diff) {
        int result = 0;
        if (center >= sensor) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < diff.length - (center - 1); i++) {
            result += diff[i];
        }
        System.out.println(result);
        return;
    }

    private static void arrayReverse(int[] sensors) {
        for (int i = 0; i < sensors.length / 2; i++) {
            int temp = sensors[i];
            sensors[i] = sensors[sensors.length-1-i];
            sensors[sensors.length-1-i] = temp;
        }
    }
}
