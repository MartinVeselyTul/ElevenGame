package vevana;

import elevengame.GameInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameUI {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
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

            while ((n = sc.nextInt()) >= 0 && i < 3) {               
                cards.add(n);                
                i++;
            }
            
            //1. ziskat points u vybranych karet
            //2. predelat kontrolu 11 a 0
            //3. zjistit, kdyz je soucet 0, zda jsou 3 karty
            //4. 
     
        } while (game.anotherPlayIsPossible() );
        //&& !game.isWon()
    }
}
