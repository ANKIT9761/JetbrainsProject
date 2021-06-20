package tictactoe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class hardLevel {
    static boolean winning(String [][] grid,String player){
        int arr[][]={{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
        for(int []ar:arr){
            if(grid[ar[0] / 3][ar[0] % 3].equals(grid[ar[1] / 3][ar[1] % 3]) && grid[ar[1] / 3][ar[1] % 3].equals(grid[ar[2] / 3][ar[2] % 3])){
                if(grid[ar[0] / 3][ar[0] % 3].equals(" ")){
                    continue;
                }
                if(grid[ar[0] / 3][ar[0] % 3].equals(player)){
                    return true;
                }
            }
        }
        return false;
    }
    static ArrayList<Integer> emptyIndexes(String [][] grid){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(grid[i][j].equalsIgnoreCase(" ")){
                    temp.add(3*i+j);
                }
            }
        }
        return temp;

    }
    static HashMap<String,Integer> minMax(String [][]grid,String player,String aiPlayer,String huPlayer){
        ArrayList<Integer> emptyIndexes=emptyIndexes(grid);

        if(winning(grid,aiPlayer)){
            return new HashMap<String,Integer>(){{put("score",10);}};
        }
        else if(winning(grid,huPlayer)){
            return new HashMap<String,Integer>(){{put("score",-10);}};
        }
        else if(emptyIndexes.size()==0){
            return new HashMap<String,Integer>(){{put("score",0);}};
        }

        ArrayList<HashMap<String,Integer>> moves=new ArrayList<>();
        for(int i=0;i<emptyIndexes.size();i++){
            HashMap<String,Integer> move=new HashMap<>();
            int index=emptyIndexes.get(i);
            grid[index/3][index%3]=player;
            move.put("index",index);

            Map<String,Integer> result=minMax(grid,(player.equalsIgnoreCase("X")?"O":"X"),aiPlayer,huPlayer);
            move.put("score",result.get("score"));
            moves.add(move);
            grid[index/3][index%3]=" ";

        }
        int bestMove = 0;
        if(player.equalsIgnoreCase(aiPlayer)){
            int bestScore=-100000;
            for(int i=0;i<moves.size();i++){
                if(moves.get(i).get("score")>bestScore){
                    bestScore=moves.get(i).get("score");
                    bestMove=i;
                }
            }
        }
        else{
            int bestScore=100000;
            for(int i=0;i<moves.size();i++){
                if(moves.get(i).get("score")<bestScore){
                    bestScore=moves.get(i).get("score");
                    bestMove=i;
                }
            }
        }
        ;
        
        return moves.get(bestMove);

    }
    public static void hardLevelAi(String [][] grid,String turn){
        String huPlayer=(turn.equalsIgnoreCase("X")?"O":"X");

        ArrayList<Integer> emptyIndexes=emptyIndexes(grid);
        Map<String,Integer> move=minMax(grid, turn, turn,huPlayer);
        int bestMove=move.get("index");
        System.out.println("Making move level \"hard\"");

        grid[bestMove/3][bestMove%3]=turn;

    }
}
