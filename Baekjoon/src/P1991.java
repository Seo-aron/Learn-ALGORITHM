import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Tree{
    char value;
    Tree left;
    Tree right;

    public Tree(char value) {
        this.value = value;
    }
}

public class P1991 {
    static Map<Character, Tree> treeMap =  new HashMap<>();
    static Tree root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            // 처음 루트가 없을 시 생성
            treeMap.putIfAbsent(parent, new Tree(parent));
            Tree parentNode = treeMap.get(parent);

            // 루트는 첫 줄 실행 시
            if (i==0) root = parentNode;

            if (left != '.'){
                treeMap.putIfAbsent(left, new Tree(left));
                parentNode.left = treeMap.get(left);
            }

            if (right != '.') {
                treeMap.putIfAbsent(right, new Tree(right));
                parentNode.right = treeMap.get(right);
            }
        }

        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
    }

    private static void preorder(Tree root) {
        if (root == null) return;
        System.out.print(root.value);
        preorder(root.left);
        preorder(root.right);
    }

    private static void inorder(Tree root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.value);
        inorder(root.right);
    }

    private static void postorder(Tree root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.value);
    }

}
