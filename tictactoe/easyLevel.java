package tictactoe;

import java.util.Random;

public class easyLevel {
    public static void easyLevelAi(String[][] grid,String turn){
        Random random=new Random();
        int choice=random.nextInt(9);
        while(!grid[choice/3][choice%3].equals(" ")){
            choice=random.nextInt(9);
        }
        System.out.println("Making move level \"easy\"");
        grid[choice/3][choice%3]=turn;
    }
}
