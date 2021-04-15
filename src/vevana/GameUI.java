package vevana;

import elevengame.GameInterface;

public class GameUI {
    
    
    public static void main(String[] args) {
        GameInterface game = new GameImplementation();
        System.out.println("Vítejte ve hře "+ game.getName());
        
        System.out.println("V balíčku je "+ game.getDeckSize());
        
        for (int i = 0; i < game.nCards(); i++) {
            System.out.println(game.getCardDescriptionAt(i) + " na indexu " + i);
        }
    }
}
