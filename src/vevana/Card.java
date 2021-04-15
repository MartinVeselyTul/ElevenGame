package vevana;

public class Card {
    private String value;
    private String symbol;
    private int point;

    public Card(String value, String symbol, int point) {
        this.value = value;
        this.symbol = symbol;
        this.point = point;
    }

    public String getValue() {
        return value;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getPoint() {
        return point;
    }

    @Override
    public String toString() {
        return "Card{" + "value=" + value + ", symbol=" + symbol + ", point=" + point + '}';
    }
    
    
}
