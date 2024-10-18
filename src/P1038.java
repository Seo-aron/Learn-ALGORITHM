import java.util.*;

public class P1038 {
    static List<Long> num = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        if(N <= 10){
            System.out.println(N);
        } else if(N >= 1023){
            // 2^10 - 1 = 1023
            // 0~9까지 한 번 쓴 숫자는 못씀 => 2^10, 0~9까지 하나도 안씀 => -1
            System.out.println("-1");
        } else{
            for(long i = 0; i < 10; i++){
                back_brute(1, i);
            }
        }

        Collections.sort(num);      // 리스트 오름차순 정렬
        System.out.println(num.get(N)); // 리스트의 N번째에 있는 수 반환, [0]부터 시작

        sc.close();
    }
    private static void back_brute(int idx, long arr){
        if(idx > 10){
            return;
        }
        num.add(arr);
        for(int i = 0; i < arr % 10; i++){
            back_brute(idx + 1, (arr * 10) + i);
        }
    }
}