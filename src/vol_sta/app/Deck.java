package vol_sta.app;

/**
 * @author starkov
 */
import vol_sta.app.Card;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = Card.allCards();
        Collections.shuffle(cards);
    }

    /**
     * Returns size of deck
     * @return size of deck
     */
    public int getSize(){
        return this.cards.size();
    }

    /**
     * Is deck empty?
     * @return true if empty
     */
    public boolean isEmpty() {
        
        return this.cards.isEmpty();
    }

    /**
     * Picks specific amount of cards
     * @param count - number of cards
     * @return array of cards
     * @throws IllegalArgumentException - count is <1 or >size of deck
     */
    public Card[] pick(int count) throws IllegalArgumentException {
        
        //Checks if number of cards taken is valid
        if (count < 1 || count > cards.size()) {
            throw new IllegalArgumentException("Nelze vybrat " + count + " karet");
        }

        Card[] picked = new Card[count];

        for (int i = 0; i < count; i++) {
            picked[i] = pick();
        }

        return picked;
    }

    /**
     * Picks card at index
     * @return Card
     */
    public Card pick(){
        if (isEmpty()) {
            return null;
            //throw new IllegalAccessException("You cannot pick a card, the deck is empty");
        }

        Card card = cards.get(0);
        cards.remove(0);

        return card;
    }

    /**
     * Returns new instance of Deck
     * @return Deck
     */
    public static Deck initFull() {
        return new Deck();
    }
}
