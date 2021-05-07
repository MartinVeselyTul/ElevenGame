/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safikri;

import elevengame.DataStore;

/**
 *
 * @author sarka
 */
public class Card {

    private String value;
    private String symbol;
    private int[] npoint = DataStore.loadNPoints();
    private String[] values = DataStore.loadValues();

    public Card(String value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public int getRank() {
        for (int i = 0; i < values.length; i++) {
            if (value == values[i]) {
                return npoint[i];
            }
        }
        return 0;
    }

    public static Card getByFactory(String[] features) {
        return new Card(features[0], features[1]);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        String textValue, textSymbol;
        switch (symbol) {
            case "spades":
                textSymbol = "♠";
                break;
            case "diamonds":
                textSymbol = "♦";
                break;
            case "clubs":
                textSymbol = "♣";
                break;
            case "hearts":
                textSymbol = "♥";
                break;
            default:
                textSymbol = symbol;
        }
        if (getRank() > 1) {
            textValue = value;
        } else if (getRank() == 1) {
            textValue = "A";
        } else {
            switch (value) {
                case "jack":
                    textValue = "J";
                    break;
                case "queen":
                    textValue = "Q";
                    break;
                case "king":
                    textValue = "K";
                    break;
                default:
                    textValue = value;
            }
        }
        return String.format("%s %s", textValue, textSymbol);
    }
    /*
    public static void main(String[] args) {
        Card c = new Card("2","spades");
        System.out.println(c.getRank());
    }
     */

}
