//update kodu v PC (Martin)
package vevana;

import elevengame.DataStore;
import elevengame.GameInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameImplementation implements GameInterface {

    List<Card> deck = new ArrayList<>();
    List<Card> table = new ArrayList<>();

    public GameImplementation() {
        String[] symbol = DataStore.loadSymbols();
        String[] values = DataStore.loadValues();
        int[] points = DataStore.loadNPoints();

        for (String string : symbol) {
            for (int i = 0; i < 13; i++) {
                Card c = new Card(values[i], string, points[i]);
                deck.add(c);
            }
        }
        Collections.shuffle(deck);
        for (int i = 0; i < nCards(); i++) {
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
            
            for (int i = 0; i < n; i++) {
                if (table.get(i).getPoint() == 0) {
                    triplet++;
                } else {
                    sum += table.get(i).getPoint();
                }
            }
            if (triplet >= 3){
                for (int i = 0; i < triplet; i++) {                    
                    if(table.contains(DataStore.getTriple())){
                        return true;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = n-1; j >= 0; j--) {
                    if(table.get(i).getPoint() + table.get(j).getPoint() == 11){                        
                        return true;
                    }
                }
            }
            
//            if (sum / n >= 11 && triplet >= 3) {
//                return true;
//            }
        }
        return false;
    }


    @Override
    public boolean playAndReplace(List<Integer> iSelectedCards) {
        switch (iSelectedCards.size()) {
            case 2:
                if ((table.get(iSelectedCards.get(0)).getPoint() + table.get(iSelectedCards.get(1)).getPoint()) == 11) {
                      int num1 = iSelectedCards.get(0);
                      int num2 = iSelectedCards.get(1);
                      
                      table.remove(num1);
                      int n1 = Random(deck.size());
                      table.add(num1 ,deck.remove(n1));
                      
                      table.remove(num2);
                      int n2 = Random(deck.size());
                      table.add(num2 ,deck.remove(n2));
                }
                      return true;                
                
            case 3:                 
                String[] choosenCards = new String[3];
                for (int i = 0; i < 3; i++) {
                    int n = iSelectedCards.get(i);
                    choosenCards[i] = table.get(n).getValue();
                }
                List<String> myCards = new ArrayList<>();
                Collections.addAll(myCards, choosenCards);
                List<String> store = new ArrayList<>();               
                Collections.addAll(store, DataStore.getTriple());
                
                if (store.containsAll(myCards)) {                    
                    for (int i = 0; i <= 2; i++) {                        
                        int n = iSelectedCards.get(i);
                        table.remove(n);
                        int nRand = Random(deck.size());
                        table.add(n ,deck.remove(nRand));                        
                    }
                    
                }
                return true;
            default:
                return false;
        }
        //return false;
    }

    @Override
    public boolean isWon() {
        return table.isEmpty() && deck.isEmpty();
    }

    private int Random(int n) {
        Random rnd = new Random();
        return rnd.nextInt(n);
    }
}
