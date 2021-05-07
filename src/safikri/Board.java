/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safikri;

import elevengame.DataStore;
import java.util.List;

/**
 *
 * @author sarka
 */
public class Board {

    private int cardNum = DataStore.getNCards();
    private Card[] board;
    private Deck deck;

    public Board(Deck deck) {
        this.deck = deck;
        board = new Card[cardNum];
        prepareBoard();
    }

    public Deck getDeck() {
        return deck;
    }

    public void setBoard(int index, Card c) {
        this.board[index] = c;
    }

    public Card[] getBoard() {
        return board;
    }

    private void prepareBoard() {
        Card[] prep = new Card[cardNum];
        deck.shuffle();
        for (int i = 0; i < cardNum; i++) {
            prep[i] = deck.draw();
        }
        board = prep;
    }

    public Card getCardAt(int inx) {
        return board[inx];
    }

    public boolean triplePresent() {
        boolean J = false;
        boolean Q = false;
        boolean K = false;
        for (Card c : board) {
            switch (c.getValue()) {
                case "king":
                    K = true;
                    break;
                case "queen":
                    Q = true;
                    break;
                case "jack":
                    J = true;
                    break;
                default:
                    break;
            }
        }
        if (J && Q && K) {
            return true;
        }
        return false;
    }

    public boolean elevenPresent() {
        for (int i = 0; i < board.length; i++) {
            for (int j = i + 1; j < board.length; j++) {
                if (board[i].getRank() + board[j].getRank() == 11) {
                    return true;
                }
            }
        }
        return false;
    }
    /*
    public static void main(String[] args) {
        Deck d =new Deck();
        Board b=new Board(d);
        b.prepareBoard();
        System.out.println(b.getCardAt(2));
        
    }*/
}
