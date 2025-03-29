import java.io.*;
import java.util.*;

public class P10816 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int player = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < player; i++){
            int num = Integer.parseInt(st.nextToken());
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        int card = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < card; i++){
            int num = Integer.parseInt(st.nextToken());
            sb.append(hashMap.getOrDefault(num, 0)).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
