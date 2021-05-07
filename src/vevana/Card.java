package vevana;

public class Card {

    private final String value;
    private final String symbol;
    private final int point;

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
        //♦ ♥ ♠ ♣
        return ("jack".equals(value) ? "J"
                : "queen".equals(value) ? "Q"
                : "king".equals(value) ? "K"
                : "ace".equals(value) ? "A"
                : value)
                + (("hearts".equals(symbol)) ? "♥ "
                : ("clubs".equals(symbol)) ? "♣ "
                : ("diamonds".equals(symbol)) ? "♦ "
                : ("spades".equals(symbol)) ? "♠ "
                : " ◙ ")
                + " body: " + point;
    }
}
