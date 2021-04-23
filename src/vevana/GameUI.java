package vevana;

import elevengame.GameInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameUI {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            GameInterface game = new GameImplementation();
            System.out.println("Vítejte ve hře " + game.getName());

            do {
                System.out.println("V balíčku je " + game.getDeckSize());

                for (int i = 0; i < game.nCards(); i++) {
                    System.out.println(game.getCardDescriptionAt(i) + " na indexu " + i);
                }

                System.out.println("Vyberte karty");
                System.out.println("Dvě se součtem 11, nebo tři s hodnotami karty J Q K");
                List<Integer> cards = new ArrayList<>();
                int n;
                int i = 0;
                //pridat if + pripadne shuffle karet
                while ((n = sc.nextInt()) >= 0 && i < 3) {
                    cards.add(n);
                    i++;
                }
                System.out.println(cards.toString());
                game.playAndReplace(cards);

                if (game.playAndReplace(cards) == false) {
                    System.out.println("Nauc se pocitat...");
                }
                if (game.anotherPlayIsPossible() == false) {
                    System.out.println("Nejsou k dispozici další tahy.");
                    System.out.println("Pro další hru stiskněte vyšší číslo než 0");
                }
                if (game.isWon() == true) {
                    System.out.println("Vyhráli jste!!!");
                    System.out.println("Pro další hru stiskněte vyšší číslo než 0");
                }
            } while (game.anotherPlayIsPossible() && !game.isWon());
        } while (sc.nextInt() > 0);
    }
}
