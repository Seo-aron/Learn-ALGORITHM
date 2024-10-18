import java.util.Scanner;

public class P2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String init = sc.nextLine();
        int cnt = 0;

        for(int i = 0; i < init.length(); i++){
            if(i < init.length()-2){
                String croa_dz = init.substring(i, i+3);
                if(croa_dz.equals("dz=")){
                    cnt++;
                    i += 2;
                    continue;
                }
            }
            if(i < init.length()-1){
                String croa = init.substring(i, i+2);
                switch (croa) {
                    case "c=":
                    case "c-":
                    case "d-":
                    case "lj":
                    case "nj":
                    case "s=":
                    case "z=":
                        cnt++;
                        i++;
                        continue;
                }
            }
            cnt++;
        }

        System.out.println(cnt);

        sc.close();
    }
}