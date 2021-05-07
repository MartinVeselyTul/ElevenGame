/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safikri;

import java.util.List;
import elevengame.DataStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import safikri.Card;

/**
 *
 * @author sarka
 */
public class Deck {

    private Stack<Card> deckStack;                   //Garbage deck of cards
    private String[] values = DataStore.loadValues();
    private String[] symbols = DataStore.loadSymbols();
    final private int N = 52;                           //Number of cards in a deck

    public Deck() {
        deckStack = new Stack<>();
        for (int i = 0; i < (getPermts().length); i++) {
            deckStack.add(Card.getByFactory(getPermts()[i]));
        }
    }

    public void shuffle() {
        Collections.shuffle(deckStack);
    }

    public Card draw() {
        return deckStack.pop() ;
    }

    public Stack<Card> getDeckStack() {
        return deckStack;
    }
    

    private String[][] getPermts(){
        String[][] permts = new String[N][2];
        for (int j = 0; j < symbols.length; j++) {
            for (int i = 0; i < values.length; i++) {
                permts[j * 13 + i][0] = values[i];
                permts[j * 13 + i][1] = symbols[j];
            }
        }
        return permts;
    }

    public int getSize(){
        return deckStack.size();
    }
    
   /*
    public static void main(String[] args) {
        Deck d = new Deck();
        String[][] permts = d.getPermts();
        for (String[] array : permts) {
            System.out.format("%s %s, ", array[0], array[1]);
        }
        System.out.println("");
        for (Card c : d.deckStack) {
            System.out.print(c.toString());
        }
        d.shuffle();
        System.out.println("");
        for (Card c : d.deckStack) {
            System.out.print(c.toString());
        }
        System.out.println("");
        Card a=d.draw();
        System.out.println(a.toString());
        System.out.println("");
        for (Card c : d.deckStack) {
            System.out.print(c.toString());
        }
    }*/

}
