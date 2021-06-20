package tictactoe;

import java.util.Random;
import static tictactoe.GameLogic.*;

public class mediumLevel {
    public static void mediumLevelAi(String [][] grid,String turn){
        int winPos=-1;
        winPos=canWinPosition(turn,grid);

        String nextTurn=(turn.equalsIgnoreCase("X"))?"O":"X";

        int losPos=-1;
        losPos=canWinPosition(nextTurn,grid);

        System.out.println("Making move level \"medium\"");
        if(winPos!=-1){
            grid[winPos/3][winPos%3]=turn;
        }
        else if(losPos!=-1){
            grid[losPos/3][losPos%3]=turn;
        }
        else{
            Random random=new Random();
            int choice=random.nextInt(9);
            while(!grid[choice/3][choice%3].equals(" ")){
                choice=random.nextInt(9);
            }
            grid[choice/3][choice%3]=turn;
        }

    }
}
