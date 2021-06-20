package tictactoe;

import java.util.Scanner;

import static tictactoe.easyLevel.easyLevelAi;
import static tictactoe.mediumLevel.mediumLevelAi;
import static tictactoe.checkGameFinished.*;
import static tictactoe.hardLevel.hardLevelAi;


public class GameLogic {

    public static void playGame(String user1,String user2){
        String[][] grid=new String[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                grid[i][j]=String.valueOf(' ');
            }
        }
        int totalMoves=0;
        String turn="X";
        Scanner sc=new Scanner(System.in);
        String playingUser=user1;

        displayBoard(grid);
        while(true){
            if(playingUser.equals("user")){
                System.out.print("Enter the coordinates: > ");
                String [] arr=sc.nextLine().split(" ");
                try{
                    System.out.println(Integer.parseInt(arr[0])+" "+Integer.parseInt(arr[1]));
                    int x=Integer.parseInt(arr[0]);
                    int y=Integer.parseInt(arr[1]);
                    if(x<1 || x>3 || y<1 || y>3){
                        System.out.println("Coordinates should be from 1 to 3!");
                    }

                    else if(!grid[x - 1][y - 1].equals(" ")){
                        System.out.println("This cell is occupied! Choose another one!");
                    }

                    else{
                        grid[x-1][y-1]=turn;

                    }
                }
                catch(Exception e){
                    System.out.println("You should enter numbers!");
                    continue;


                }

            }

            else if(playingUser.equalsIgnoreCase("easy")){
                easyLevelAi(grid,turn);
            }

            else if(playingUser.equalsIgnoreCase("medium")){
                mediumLevelAi(grid,turn);
            }

            else if(playingUser.equalsIgnoreCase("hard")){
                hardLevelAi(grid,turn);
            }
            boolean gameFinished=isGameFinished(grid);
            displayBoard(grid);
            totalMoves++;

            if(gameFinished){
                System.out.println(turn+" wins");
                break;
            }
            if(totalMoves==9){
                System.out.println("Draw");
                break;
            }
            turn=(turn.equalsIgnoreCase("X"))?"O":"X";
            playingUser=(playingUser.equalsIgnoreCase(user1))?user2:user1;

        }
    }

    public static int canWinPosition(String turn,String [][] grid){
        int arr[][]={{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
        for(int i=0;i<8;i++){
            int count=0;
            int pos=-1;
            int cur=-1;
            for(int j=0;j<3;j++){
                cur=arr[i][j];
                if(grid[cur/3][cur%3].equals(turn)){
                    count++;
                }
                else if(grid[cur/3][cur%3].equals(" ")){
                    pos=cur;
                }

            }
            if(count==2 && pos!=-1){
                return pos;
            }
        }
        return -1;
    }

}
