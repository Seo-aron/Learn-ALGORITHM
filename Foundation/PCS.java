/*
    순열(Permutation), 조합(Combination), 부분집합(Subsets)
    
    - 순열 (Permutation) : 서로 다른 n개의 원소 중 r개를 **순서 있게** 골라낸 것 (nPr)
            식 : n! / (n-r)!

    - 조합 (Combination) : 서로 다른 n개의 원소 중 r개를 **순서 없이** 골라낸 것 (nCr)
            식 : n! / (r! * (n-r)!)

    - 부분집합 (Subsets) : 주어진 n개의 원소에서 일부 또는 전부를 선택하는 경우의 수
            총 개수 : 2^n (공집합 포함)
 */
package Foundation;

import java.util.ArrayList;
import java.util.List;

public class PCS {
    // 순열
    public static void permutation(int[] arr, boolean[] visited, List<Integer> result, int r){
        if (result.size() == r) {
            System.out.println(result);
            return;
        }
        for (int i = 0; i < arr.length; i++){
            if (!visited[i]) {
                visited[i] = true;
                result.add(arr[i]);
                permutation(arr, visited, result, r);
                result.remove(result.size()-1);
                visited[i] = false;
            }
        }
    }
    
    // 조합
    public static void combination(int[] arr, List<Integer> result, int start, int r){
        if (result.size() == r) {
            System.out.println(result);
            return;
        }
        for (int i = start; i < arr.length; i++){
            result.add(arr[i]);
            combination(arr, result, i + 1, r);
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int r = 2;

        System.out.println("순열");
        permutation(arr, new boolean[arr.length], new ArrayList<>(), r);

        System.out.println("조합");
        combination(arr, new ArrayList<>(), 0, r);
    }
 }