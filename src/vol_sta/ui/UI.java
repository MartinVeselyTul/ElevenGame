package vol_sta.ui;

import elevengame.GameInterface;
import vol_sta.app.Game;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {
    
    public static void runGame(){
        Scanner sc = new Scanner(System.in);
        GameInterface g = new Game();
        
        System.out.println(g.getName());

        List<Integer> iSelectedCards = new ArrayList<>();
        while (g.anotherPlayIsPossible()) {
            System.out.print(display(g));
            // metoda, ve ktere uzivatel napise počet vybraných karet a poté jejich cisla
            int count = sc.nextInt();
            for (int i = 0; i < count; i++) {
                //nacteni kombinací
                iSelectedCards.add(sc.nextInt());
            }
            if(!g.playAndReplace(iSelectedCards)){
                System.out.println("Chybný tah! Zkuste to prosím znovu");
            }
            
            iSelectedCards.clear();
        }
        if (g.isWon()) {
            System.out.println("Vyhrál jsi!");
        } else {
            System.out.println("Prohrál jsi");
        }
    }
    
    /**
     * Returns display string
     * @param g
     * @return String - display
     */
    private static String display(GameInterface g) {
        StringBuilder builder = new StringBuilder("Velikost balíčku: "+g.getDeckSize()+"\n");
        for (int i = 0; i < g.nCards(); i++) {
            builder.append(String.format("%2d",i));
            builder.append(".  ");
            builder.append(g.getCardDescriptionAt(i));
            builder.append("\n");
        }
        builder.append("*********************************************\n");
        builder.append("Vyberte 2 nebo 3 karty abyste získali 11 bodů.\n");
        builder.append("Zadejte počet vybraných karet a poté jejich cisla:\n");

        return builder.toString();
    }
    
    public static void main(String[] args) {
        UI.runGame();
    }
    
}
