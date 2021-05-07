/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safikri;

import elevengame.GameInterface;
import java.util.List;

/**
 *
 * @author sarka
 */
public class ElevenGame implements GameInterface {

    private Deck gameDeck;
    private Board gameBoard;
    private String name = "♦ ♠ Eleven Game ♣ ♥";
    private int nOfCards = 9;

    public ElevenGame() {
        gameDeck = new Deck();
        gameBoard = new Board(gameDeck);
    }

    @Override
    public String getName() {
        return name;
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public Deck getGameDeck() {
        return gameDeck;
    }

    @Override
    public int nCards() {
        return nOfCards;
    }

    @Override
    public int getDeckSize() {
        return gameDeck.getSize();
    }

    @Override
    public String getCardDescriptionAt(int index) {
        return gameBoard.getCardAt(index).toString();
    }

    @Override
    public boolean anotherPlayIsPossible() {
        if (gameBoard.triplePresent() || gameBoard.elevenPresent()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean playAndReplace(List<Integer> iSelectedCards) {
        boolean playable = false;
        if (iSelectedCards.size() > 3) {
            return false;
        } else if (iSelectedCards.size() == 3) {
            boolean triple = true;
            for (int i = 0; i < 3; i++) {
                if (gameBoard.getBoard()[iSelectedCards.get(i)].getRank() != 0) {
                    triple = false;
                }
            }
            playable = triple;
        } else {
            if (gameBoard.getBoard()[iSelectedCards.get(0)].getRank() + gameBoard.getBoard()[iSelectedCards.get(1)].getRank() == 11) {
                playable = true;
            } else {
                playable = false;
            }
        }

        if (playable) {
            for (Integer selected : iSelectedCards) {
                gameBoard.setBoard(selected, gameDeck.draw());
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean isWon() {
        return gameBoard.getDeck().getDeckStack().empty();
    }
    /*
    public static void main(String[] args) {
        ElevenGame g=new ElevenGame();
        System.out.println(g.getCardDescriptionAt(2));
    }*/
}
