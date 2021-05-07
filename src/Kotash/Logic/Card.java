package Kotash.Logic;

/**
 *
 * @author pytel
 */
public class Card {

    private final String symbol;
    private final String value;
    private final int point;

    public Card(String symbol, String value, int point) {
        this.symbol = symbol;
        this.value = value;
        this.point = point;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getValue() {
        return value;
    }

    public int getPoint() {
        return point;
    }

    @Override
    public String toString() {
        return symbol + "-" + value;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Card c = new Card("hearts", "ace", 1);
        
        System.out.format("Symbol: %s \n", c.getSymbol());
        System.out.format("Value: %s \n", c.getValue());
        System.out.format("Point: %d \n", c.getPoint());
        
        System.out.format("Card: %s \n", c);
        
    }
    
}
