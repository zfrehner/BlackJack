package game;

import card.StandardCard;
import deck.BlackJack;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class is the game play for blackjack using the standard card class
 * @author Zach Frehner
 * @version 1.o
 */
public class BlackJackGame {

    public static final int WINNER = 21;
    public static boolean game = true;
    public static boolean answer = true;
    public static boolean playerLoss = false;
    public static boolean dealerPlays = true;
    //scanner obj
    public static Scanner scan = new Scanner(System.in);
    //construct the new BJ object
    public static BlackJack blackJack = new BlackJack();

    /**
     * main method for running the gameplay
     * @param args command line args
     */
    public static void main(String[] args) {

        while(game) {
            dealerPlays = true;
            blackJack.setPlayerTotal(0);
            blackJack.setDealerTotal(0);

            playerTurn();
            System.out.println();

            dealerTurn();
            System.out.println();

            playAgain();
            System.out.println();
        }

        }


    /**
     * checks if the players cards total to 21
     * @param playerTotal total of players cards
     * @return true if total == 21
     */
    public static boolean isWinner(int playerTotal) {

        return playerTotal == WINNER;
    }

    /**
     * checks if the players cards total over 21
     * @param playerTotal total of players cards
     * @return true if the total is over 21
     */
    public static boolean isBust(int playerTotal) {
        return playerTotal > WINNER;
    }

    /**
     * check if the player and dealer are at the same value
     * @param playerTotal player cards total
     * @param dealerTotal dealers cards total
     * @return true if the dealer and player have the same value
     */
    public static boolean isTie(int playerTotal, int dealerTotal) {
        return playerTotal == dealerTotal;
    }

    /**
     * method for running the player taking their turn first
     * checks are included for if they hit 21 or go over
     * starts by dealing 2 cards and asking if they want to hit, then
     * deals one card at a time
     */
    public static void playerTurn() {

        //set up the stream of the first two cards
        Stream<StandardCard> firstCards = blackJack.dealTwoCards();

        //save the cards into a list
        List<StandardCard> listCards = firstCards.collect(Collectors.toList());
        listCards.forEach(x -> System.out.println("You were dealt a " + x));

        //use maptoInt() and get the sum of the players cards
        blackJack.setPlayerTotal(listCards.stream().mapToInt(x -> x.getRankValue()).sum());
        //listCards.forEach(x -> blackJack.setPlayerTotal(x.getRankValue()));

        //checks for going over and winning conditions
        if (isBust(blackJack.getPlayerTotal())) {
            System.out.println("Your total is " + blackJack.getPlayerTotal());
            System.out.println("You went bust! Dealer Wins!");
            playerLoss = true;
            dealerPlays = false;
            //break;
        }
        if (isWinner(blackJack.getPlayerTotal())) {
            System.out.println("Your total is " + blackJack.getPlayerTotal()+ " , hit?");
            answer = scan.nextBoolean();
            game = false;
            dealerPlays = true;
        }
        if (game) {
            System.out.print("Your total is " + blackJack.getPlayerTotal() + " , hit?");
            answer = scan.nextBoolean();
        }

        //continues to deal cards until the answer is false or player goes over
        while (answer && game) {
            StandardCard oneCard = blackJack.dealOneCard();
            System.out.println("You were dealt a " + oneCard);
            blackJack.setPlayerTotal(oneCard.getRankValue());
            if (isBust(blackJack.getPlayerTotal())) {
                System.out.println("Your total is " + blackJack.getPlayerTotal());
                System.out.println("You went bust! Dealer Wins!");
                game = false;
                playerLoss = true;
                dealerPlays = false;
                break;
            }
            if (isWinner(blackJack.getPlayerTotal())) {
                System.out.println("Your total is " + blackJack.getPlayerTotal());
                break;
            }
            System.out.print("Your total is " + blackJack.getPlayerTotal() + " , hit?");
            answer = scan.nextBoolean();
        }
    }


    /**
     * the dealers game play - deals one card at a time until the go over 21 or win the game
     * by hitting 21
     */
    public static void dealerTurn() {

        while (dealerPlays) {
            StandardCard oneCard = blackJack.dealOneCard();
            System.out.println("Dealer was dealt a " + oneCard);
            blackJack.setDealerTotal(oneCard.getRankValue());
            if (isBust(blackJack.getDealerTotal())) {
                System.out.println("Dealer total is " + blackJack.getDealerTotal());
                System.out.println("Dealer went bust! You Win!");
                break;
            }
            if(isTie(blackJack.getDealerTotal(), blackJack.getPlayerTotal())) {
                System.out.println("Game is a Tie!");
                break;
            }
            if (isWinner(blackJack.getDealerTotal())) {
                System.out.println("Dealer total is " + blackJack.getDealerTotal());
                System.out.println("Dealer Wins!");
                break;
            }
            System.out.println("Dealer total is " + blackJack.getDealerTotal());

        }

    }

    /**
     * asks the user if they want to play again and if true
     * starts the game over
     */
    public static void playAgain() {
        System.out.println("Would you like to play again?");
        //game = true;
        game = scan.nextBoolean();
    }

}
