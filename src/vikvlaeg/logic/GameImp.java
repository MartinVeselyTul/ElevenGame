package vikvlaeg.logic;

import vikvlaeg.logic.Card;
import elevengame.DataStore;
import elevengame.GameInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameImp implements GameInterface {
    private List<Card> deck = new ArrayList<>();
    private List<Card> playerDeck = new ArrayList<>(nCards());

    public GameImp() {
        String[] values = DataStore.loadValues();
        String[] symbols = DataStore.loadSymbols();
        int[] nPoints = DataStore.loadNPoints();
        for (int i = 0; i < symbols.length; i++) {
            for (int j = 0; j < values.length; j++) {
                Card c = new Card(symbols[i], values[j], nPoints[j]);
                deck.add(c);
            }
        }
        Collections.shuffle(deck);
        for (int i = 0; i < nCards(); i++) {
            playerDeck.add(deck.remove(i));
        }
    }

    @Override
    public String getName() {
        return "Eleven Game";
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
        
        return playerDeck.get(index).getSymbol() + "-" + playerDeck.get(index).getValue();
    }

    @Override
    public boolean anotherPlayIsPossible() { 
        String[] triple = {"jack", "queen", "king"};
        int jackCount = 0;
        int queenCount = 0;
        int kingCount = 0;
        int temp = 0;
        for (int i = 0; i < nCards(); i++) {
             if (getCardDescriptionAt(i).contains("jack")) {
                 jackCount++;
            }
            if (getCardDescriptionAt(i).contains("queen")) {
                queenCount++;
            }
            if (getCardDescriptionAt(i).contains("king")) {
                kingCount++;
            }
        }
        label:
        for (int i = 0; i < playerDeck.size(); i++) {
            for (int j = 0; j < playerDeck.size(); j++) {
                if (playerDeck.get(i).getPoint() + playerDeck.get(j).getPoint() == 11) {
                    temp = 1;
                    break label;
                }
            }
        }
        if ((jackCount >= 1) && (queenCount >=1) && (kingCount >=1) || (temp == 1)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean playAndReplace(List<Integer> iSelectedCards) {
        String[] triple = {"jack", "queen", "king"};
        int count = 0;
        int sum = 0;
        int[] index = new int[iSelectedCards.size()];
        for (int i = 0; i < iSelectedCards.size(); i++) {
            for (int j = 0; j < triple.length; j++) {
                if (getCardDescriptionAt(iSelectedCards.get(i)).contains(triple[j])) {
                    count++;
                }
            }
            sum += playerDeck.get(iSelectedCards.get(i)).getPoint();
        }

        for (int i = 0; i < iSelectedCards.size(); i++) {
            try {
                index[i] = iSelectedCards.get(i);
                playerDeck.remove(index[i] - i);
            }catch (IndexOutOfBoundsException ex) {
                System.out.print("");
            }
        }
        for (int i = 0; i < iSelectedCards.size(); i++) {
            playerDeck.add(deck.remove(index[i]));
        }
        iSelectedCards.clear();
        if ((sum == 11) || count == 3) {
            return true;
        }


        return false;
    }

    @Override
    public boolean isWon() {
        if(!anotherPlayIsPossible() && playerDeck.size()<4) {
            return true;
        }
        return false;
    }

}
