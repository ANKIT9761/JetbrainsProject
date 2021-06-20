package tictactoe;

public class checkGameFinished {
    public static boolean isGameFinished(String[][] grid){
        int arr[][]={{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
        for(int []ar:arr){
            if(grid[ar[0] / 3][ar[0] % 3].equals(grid[ar[1] / 3][ar[1] % 3]) && grid[ar[1] / 3][ar[1] % 3].equals(grid[ar[2] / 3][ar[2] % 3])){
                if(grid[ar[0] / 3][ar[0] % 3].equals(" ")){
                    continue;
                }
                return true;
            }
        }
        return false;

    }

    public static void displayBoard(String [][] grid){
        System.out.println("-".repeat(9));
        for(int i=0;i<3;i++){
            System.out.print("| ");
            for(int j=0;j<3;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println("|");
        }
        System.out.println("-".repeat(9));

    }
}
