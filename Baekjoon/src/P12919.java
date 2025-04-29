import java.util.Scanner;

public class P12919 {
    static String s;
    static String t;
    static boolean found = false;

    public static void dfs(String str){
        if (str.length() < s.length() || found) return;

        if (str.equals(s)) {
            found = true;
            return;
        }

        if (str.charAt(str.length()-1) == 'A') {
            dfs(str.substring(0, str.length() - 1));
        }

        if (str.charAt(0) == 'B'){
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            sb.deleteCharAt(sb.length()-1);
            dfs(sb.toString());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        t = sc.next();

        dfs(t);

        if (found) System.out.println(1);
        else System.out.println(0);
    }
}