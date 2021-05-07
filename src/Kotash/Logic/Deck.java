package Kotash.Logic;

import elevengame.DataStore;

import java.util.*;

/**
 *
 * @author pytel
 */
public class Deck {
    
    private static final int SIZE = 52;
    private List<Card> deck;

    public Deck() {
        this.deck = Deck.generateDeck();
        // Colections Shuffle
        //Integer[] randomIndexs = Deck.genrerateRandomIndexs();
        //shuffleCards(cards, randomIndexs);
    }
    
    private static List<Card> generateDeck () {
        Card card;
        List<Card> cards = new ArrayList<>();
        int[] points = DataStore.loadNPoints();
        String[] values = DataStore.loadValues();
        for (String symbol : DataStore.loadSymbols()) {
            for (int i = 0 ; i < values.length; i++) {
                card = new Card(symbol, values[i], points[i]);
                cards.add(card);
            }
        }
        Collections.shuffle(cards);
        return cards;
    }

    //neni potreba uz
    /*
    private static Integer[] genrerateRandomIndexs () {
        
        // vytvori pole indexu 1:SIZE
        List<Integer> sortedIndexs = new ArrayList();
        for (int i = 0 ; i < Deck.SIZE; i++) {
            sortedIndexs.add(i);
        }
        
        // zamicha indexi
        Random ran = new Random();
        List<Integer> shuffledIndexs = new ArrayList();
        int index, position;
        while (!sortedIndexs.isEmpty()) {
            position = ran.nextInt(sortedIndexs.size());
            index = sortedIndexs.remove(position);
            shuffledIndexs.add(index);
        }
        return (Integer[]) shuffledIndexs.toArray();
    }

    //neni potreba uz
    private void shuffleCards (Card[] cards, Integer[] randomIndexs) {
        Card[] shuffledCard = new Card[Deck.SIZE];
        int index;
        for (int i = 0; i < Deck.SIZE; i++) {
            index = randomIndexs[i];
            shuffledCard[i] = cards[index];
        }
        
        this.deck = Arrays.asList(shuffledCard);
    }
    */
    
    public int getSize() {
        return this.deck.size();
    }
    
    public Card getCard() {
        int last = this.deck.size()-1;
        return this.deck.remove(last);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Deck d = new Deck();
        int number = 0;
        while (d.getSize() != 0) {
            System.out.format("Card: %s \n", d.getCard());
            number++;
        }
        System.out.println();
        System.out.format("Number of cards: %d\n", number);
    }
}
