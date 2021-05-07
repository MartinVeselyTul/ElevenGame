package vikvlaeg.logic;

public class Card {
    private String symbol;
    private String value;
    private int point;

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

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Card{" +
                "symbol='" + symbol + '\'' +
                ", value=" + value +
                ", point=" + point +
                '}';
    }

}
