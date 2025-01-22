//using System;
//
//public class P9663{
//    static int count = 0;
//    static int[] board;
//
//    static void Main(string[] args){
//        int n = int.Parse(Console.ReadLine());
//        board = new int[n];
//
//        NQueen(0, n);
//        Console.WriteLine(count);
//    }
//
//    // 백트래킹으로 퀸 배치
//    static void NQueen(int row, int n){
//        if(row == n){
//            count++;
//            return;
//        }
//
//        for(int col = 0; col < n; col++){
//            board[row] = col;
//            if(IsPromising(row)){
//                NQueen(row + 1, n);
//            }
//        }
//    }
//
//    // 현재 행까지의 배치가 유망한지 검사
//    static bool IsPromising(int row){
//        for(int i = 0; i < row; i++){
//            if(board[row] == board[i] || Math.Abs(row-1) == Math.Abs(board[row] - board[i])){
//                return false;
//            }
//        }
//        // 충돌 없음, OK
//        return true;
//    }
//}

using System;

public class Program{
    static int count = 0;
    static bool[] columns;
    static bool[] diagonals1;
    static bool[] diagonals2;

    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        columns = new bool[n];
        diagonals1 = new bool[2 * n - 1];
        diagonals2 = new bool[2 * n - 1];

        NQueen(0, n);
        Console.WriteLine(count);
    }

    static void NQueen(int row, int n)
    {
        if (row == n)
        {
            count++;
            return;
        }

        for (int col = 0; col < n; col++)
        {
            if (!columns[col] && !diagonals1[row + col] && !diagonals2[row - col + n - 1])
            {
                columns[col] = true;
                diagonals1[row + col] = true;
                diagonals2[row - col + n - 1] = true;

                NQueen(row + 1, n);

                columns[col] = false;
                diagonals1[row + col] = false;
                diagonals2[row - col + n - 1] = false;
            }
        }
    }
}