package vol_sta.app;

import vol_sta.app.Deck;
import vol_sta.app.Card;
import elevengame.DataStore;
import elevengame.GameInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import vol_sta.ui.UI;

public class Game implements GameInterface {

    private final String name = "Eleven Game";
    private int nCard;
    private Deck deck;
    public Table table;
    private String[] triple;

    public Game() {
        deck = Deck.initFull();

        loadData();
        createTable();
    }

    /**
     * Loads data from DataStore
     */
    private void loadData() {
        nCard = DataStore.getNCards();
        triple = DataStore.getTriple();
    }

    /**
     * Creates table
     */
    private void createTable() {
        try {
            table = new Table(deck.pick(nCard));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int nCards() {
        return nCard;
    }

    @Override
    public int getDeckSize() {
        return deck.getSize();
    }

    @Override
    public String getCardDescriptionAt(int index) {
        Card c = table.getCardAt(index);
        if (c != null) {
            return c.toString();
        }
        return "";
    }

    @Override
    public boolean anotherPlayIsPossible() {
        return table.doesContainPoints(11) || table.doesContainSymbols(triple);
    }

    @Override
    public boolean playAndReplace(List<Integer> iSelectedCards) {
        int count = iSelectedCards.size();
        int[] numbers = new int[iSelectedCards.size()];
        for (int i = 0; i < iSelectedCards.size(); i++) {
            numbers[i] = iSelectedCards.get(i);
        }

        switch (count) {
            //Sum of two cards points
            case 2:
                int sum = table.getPointsOfCards(numbers);
                if (table.getPointsOfCards(numbers) == 11) {
                    replace(numbers);
                    return true;
                }
                break;
            //Triple
            case 3:
                //From list to arr
                String[] selected = new String[3];
                for (int i = 0; i <= 2; i++) {
                    triple[i] = table.getCardAt(i).getValue();
                }
                if (areArraysEqual(this.triple, selected)) {
                    replace(numbers);
                    return true;
                }
                break;
        }
        return false;
    }

    @Override
    public boolean isWon() {
        return table.isEmpty() && deck.isEmpty();
    }

    private void replace(int[] indexes) {
        for (int i = 0; i < indexes.length; i++) {
            table.removeCardAt(indexes[i]);
            if (!deck.isEmpty()) {
                table.addCardTo(indexes[i], deck.pick());
            }
        }
    }

    private boolean areArraysEqual(String[] a, String[] b) {
        boolean contain;
        for (int i = 0; i < a.length; i++) {
            contain = false;
            for (int j = 0; j < b.length; j++) {
                if (a[i].equals(b[j])) {
                    contain = true;
                    break;
                }
            }
            if (!contain) {
                return false;
            }
        }
        return true;
    }

    
}
