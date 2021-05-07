/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safikri;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sarka
 */
public class UIApp {

    public static ElevenGame gameA = new ElevenGame();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.format("Welcome to %s%n", gameA.getName());
        boolean notPlayed = true;
        while (notPlayed) {
            menu1();
            int answ = sc.nextInt();
            switch (answ) {
                case 1:
                    play();
                    notPlayed = false;
                    break;
                case 2:
                    showRules();
                    break;
                case 0:
                    notPlayed = false;
                    break;
                default:
                    break;
            }
        }
    }

    public static void play() {
        boolean next = true;
        space();
        displayCards();
        if (!gameA.anotherPlayIsPossible()) {
            System.out.println("This board is not playable.");
            System.out.println("End of game.");
            next = false;
        }
        int i = 0;

        while (next) {
            if (i > 0) {
                displayCards();
            }
            i++;
            System.out.println("Insert positions of cards to be played: (terminate input with 0) ");
            List<Integer> answ = loadAnswList();
            while (answ.isEmpty()) {
                System.out.println("No such cards found on the board.");
                System.out.println("Insert positions of cards to be played: (terminate input with 0) ");
                answ = loadAnswList();
            }

            boolean playable = gameA.playAndReplace(answ);
            if (!playable) {
                System.out.println("Selected cards can not be played.");
            }
            if (!gameA.anotherPlayIsPossible()) {
                System.out.println("This board is not playable.");
                System.out.println("End of game.");
                System.out.format("Cards left in the deck: %d%n", gameA.getDeckSize());
                next = false;
            }
            if (gameA.isWon()) {
                System.out.println("No more cards in the deck. You won.");
                next = false;
            }
        }
    }

    public static void space() {
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }

    public static List<Integer> loadAnswList() {
        List<Integer> answ = new ArrayList<>();
        int c;
        int i = 0;
        do {
            c = sc.nextInt();
            if (c <= 0) {
                break;
            } else {
                c--;
            }
            answ.add(c);
            i++;
        } while (i < 3);

        return answ;
    }

    public static void displayCards() {
        System.out.println("___    ___    ___    ___    ___    ___    ___    ___    ___");
        for (int i = 0; i < gameA.nCards(); i++) {
            System.out.format("%3s  ", gameA.getCardDescriptionAt(i) + "  ");
        }
        System.out.format("     Current size of the deck: %d%n", gameA.getDeckSize());
        System.out.println("");
        System.out.println("___    ___    ___    ___    ___    ___    ___    ___    ___");
        System.out.println(" 1     2      3      4      5      6      7      8      9  ");
        System.out.println(" ");
    }

    public static void showRules() {
        System.out.println("");
        System.out.println("                                        ♦ ♠ Eleven Game Rules ♣ ♥");
        System.out.println("");
        System.out.println("The game is being played with a deck of 52 cards with values  A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, ");
        System.out.println("and symbols ♦ ♠ ♣ ♥. There are always nine cards on the board. It is possible to play the board (put chosen cards aside)");
        System.out.println("only if the chosen cards are a triple of J,Q,K, or if the point values of two chosen cards add up to 11.  ");
        System.out.println("The empty board positions are refilled from the deck. The Eleven Game ends, when the deck is empty.");
        System.out.println("        Point values of cards: ");
        System.out.println("            A=1  2=2  3=3  4=4  5=5  6=6  7=7  8=8  9=9  10=10  J=0  Q=0  K=0");
        System.out.println("");
    }

    public static void menu1() {
        System.out.println("");
        System.out.println("     Press 1 to start a new game.    ");
        System.out.println("     Press 2 to show game rules.     ");
        System.out.println("     Press 0 for game rules.         ");
    }
}
