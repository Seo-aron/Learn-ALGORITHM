using System;

public class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int square_size = brown + yellow;

        for(int i=3; i <= Math.Sqrt(square_size); i++){
            if(square_size % i == 0){
                int j = square_size / i;

                if((j-2) * (i-2) == yellow){
                    answer[0] = j;
                    answer[1] = i;
                }
            }
        }

        return answer;
    }
}