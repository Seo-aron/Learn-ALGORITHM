import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1931 {
    public static void meetingRoom(List<int[]> time){
        int result = 1;
        int nowEnd = time.get(0)[1];

        for (int i = 1; i < time.size(); i++){
            int nextStart = time.get(i)[0];

            if (nowEnd <= nextStart){
                nowEnd = time.get(i)[1];
                result++;
            }
        }

        System.out.println(result);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> time = new ArrayList<>();
        int meeting = Integer.parseInt(br.readLine());

        for (int i = 0; i < meeting; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[2];
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());

            time.add(arr);
        }

        time.sort((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        meetingRoom(time);
    }
}
