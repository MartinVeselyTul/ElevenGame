package vevana;

import elevengame.DataStore;
import elevengame.GameInterface;
import java.util.ArrayList;
import java.util.List;

public class GameImplementation implements GameInterface {

    List<Card> deck = new ArrayList<>();
    List<Card> table = new ArrayList<>();

    public GameImplementation() {
        String[] symbol = DataStore.loadSymbols();
        String[] values = DataStore.loadValues();
        int[] points = DataStore.loadNPoints();

        for (String string : symbol) {
            for (int i = 0; i<13; i++) {
                Card c = new Card(values[i], string, points[i]);
                deck.add(c);
            }
        }
        for (int i = 0; i < nCards() - 1; i++) {
            table.add(deck.remove(i));
        }
    }

    @Override
    public String getName() {
        return "Eleven game";
    }

    @Override
    public int nCards() {
        return DataStore.getNCards();
    }

    @Override
    public int getDeckSize() {
        return deck.size();
    }

    @Override
    public String getCardDescriptionAt(int index) {
        return table.get(index).toString();
    }

    @Override
    public boolean anotherPlayIsPossible() {
        if (table.size() > 1) {
            int triplet = 0;
            double sum = 0;
            int n = table.size();
            for (int i = 0; i < n;i ++) {
                if (table.get(i).getPoint() == 0) {
                    triplet++;
                } else {
                    sum += table.get(i).getPoint();
                }
            }

            if (sum / n >= 11 && triplet >= 3){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean playAndReplace(List<Integer> iSelectedCards) {
        switch (iSelectedCards.size()) {
            case 2:
                if ((table.get(iSelectedCards.get(0)).getPoint() + table.get(iSelectedCards.get(1)).getPoint()) == 11) {
                    table.remove(iSelectedCards.get(0));
                    table.remove(iSelectedCards.get(1));                    
                    return true; 
                }
                break;
            case 3:
                String[] sim = new String[3];
                for (int i = 0; i <= 2; i++) {
                    sim[i] = table.get(i).getValue();
                }
                if (sim.equals(DataStore.getTriple())) {
                    for (int i = 0; i <= 2; i++) {
                        table.remove(iSelectedCards.get(i));
                    }
                    return true;
                }
                break;
            default:
                return false;
        }
        return false;
    }

    @Override
    public boolean isWon() {
        return table.isEmpty() && deck.isEmpty();
    }

}
