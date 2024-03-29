import java.util.Scanner;
import java.lang.Math;

public class RockPaperScissor {
    enum Moves {ROCK,PAPER,SCISSOR}
    public static void main(String[] args) {
//      Prints rules, prompts user input
        System.out.println("ROCK PAPER SCISSORS!" + "\n" + "PICK A PLAY:" + "\n" + "1 = Rock"+ "\n" + "2 = Paper"+ "\n" +"3 = Scissors");
        System.out.println("Enter Number>>");
        Scanner sc = new Scanner(System.in);
        int userPlay = sc.nextInt();
//      random computer move
        int compPlay = (int)(Math.random() * 3) + 1;
//      Uses enum to get value of play
        System.out.println("Computer Play: " + Moves.values()[compPlay-1]);
        Game(userPlay, compPlay);
    }
    public static void Game(int userPlay, int compPlay){
//      Index to get value of play
        Moves userMove = Moves.values()[userPlay - 1];
        Moves compMove = Moves.values()[compPlay - 1];
//      game results
        if (userMove == compMove){
            System.out.println("It's A Tie!");
        }
        else if (userMove == Moves.ROCK & compMove == Moves.SCISSOR){
            System.out.println("You Win!");
        }
        else if (userMove == Moves.PAPER & compMove == Moves.ROCK){
            System.out.println("You Win!");
        }
        else if (userMove == Moves.SCISSOR & compMove == Moves.ROCK){
            System.out.println("You Win!");
        }
        else{System.out.println("You Lose...");}
    }

}
