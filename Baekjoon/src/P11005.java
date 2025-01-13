import java.util.Scanner;

public class P11005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int formation = scanner.nextInt();
        String mod = "";
        String result = "";

        for(int i = 0; num > 0; i++){
            mod = String.valueOf(num % formation);

            if(Integer.parseInt(mod) >= 10){
                mod = String.valueOf((char) ('A' + (Integer.parseInt(mod) - 10)));
            }

            result = result + mod;
            num = num / formation;
        }

        result = result.trim();
        result = new StringBuilder(result).reverse().toString();

        System.out.println(result);
    }
}
