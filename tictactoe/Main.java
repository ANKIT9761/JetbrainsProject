package tictactoe;

import java.util.Scanner;

import static tictactoe.GameLogic.playGame;
public class Main {


    public static void main(String[] args) {
        // write your code here

        while(true){
            Scanner sc=new Scanner(System.in);
            System.out.println("Welcome to tic-tac-toe game");
            System.out.println("There are 3 levels easy medium hard");
            System.out.println("Insert the input like this");
            System.out.println("start user hard or start medium hard");
            System.out.println("type exit to leave the game");

            System.out.print("Input command: > ");
            String [] in=sc.nextLine().split(" ");
            if(in[0].equals("exit")){
                break;
            }
            else if(in.length!=3){
                System.out.println("Bad parameters!");
            }
            else{
                String user1=in[1];
                String user2=in[2];
                playGame(user1,user2);
                System.out.println();
            }
        }

    }
}
