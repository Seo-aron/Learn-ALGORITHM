import java.util.Scanner;

public class P10799 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int barCnt = 0;     // 막대기 갯수
        int barSum = 0;     // 막대기 총 갯수
        String bar = sc.nextLine();

        for (int i = 0; i < bar.length(); i++){
            if(bar.charAt(i) == '('){
                if(bar.charAt(i + 1) == ')'){
                    barSum += barCnt;
                    i++;
                } else {
                    barCnt++;
                    barSum++;
                }
            } else {
                barCnt--;
            }
        }
        sc.close();
        System.out.println(barSum);
    }
}
