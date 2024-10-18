import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());   // 달팽이가 낮동안 오르는 미터
        int B = Integer.parseInt(st.nextToken());   // 달팽이가 밤동안 떨어지는 미터
        int V = Integer.parseInt(st.nextToken());   // 나무 높이
        int day;

        day = (V - B) / (A - B);
        if((V - B) % (A - B) != 0){
            day++;
        }
        
        System.out.println(day);
    }
}
