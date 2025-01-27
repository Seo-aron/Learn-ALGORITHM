import java.util.Scanner;

public class P9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < cnt; i++){
            boolean flag = true;
            int open_ = 0;
            String ps = sc.nextLine();

            for (int j = 0; j < ps.length(); j++){
                if(ps.charAt(j) == '('){
                    open_++;
                } else{
                    if(open_ > 0){
                        open_--;
                    } else {
                        flag = false;
                        System.out.println("NO");
                        break;
                    }
                }
            }

            if(flag && open_ == 0){
                System.out.println("YES");
            } else if(flag && open_ != 0) {
                System.out.println("NO");
            }
        }
    }
}
