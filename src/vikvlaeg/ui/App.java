package vikvlaeg.ui;

import vikvlaeg.ui.GameInfo;
import vikvlaeg.logic.GameImp;
import elevengame.GameInterface;

import java.util.*;

public class App {
    final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        GameInterface game = new GameImp();
        GameInfo rules = new GameInfo();
        List<Integer> selectedCards = new ArrayList<>();
        System.out.println("What you want?");
        System.out.println("To get rules press 1");
        System.out.println("To get beautiful rules press 2");
        System.out.println("To start press 3");
        System.out.println("To exit press 4");
        int choice;
        do {
            choice = sc.nextInt();
            switch (choice) {
                case 1 : System.out.println(rules.rules());
                case 2 : System.out.println(rules.beatifulRules());
                case 3 : {
                    for (int i = 0; i < (game.getDeckSize() / 2) + 1; i++) {
                        System.out.println(game.getName());
                        System.out.println("Cards in the deck " + game.getDeckSize());
                        for (int j = 0; j < game.nCards(); j++) {
                            System.out.println(game.getCardDescriptionAt(j));
                        }
                        if (!game.anotherPlayIsPossible()) {
                            System.out.println("You don't have any more moves");
                            break;
                        }
                        System.out.println("Do you have triple?");
                        System.out.println("Yes/No");
                        String od = sc.next().toLowerCase();
                        System.out.println("Remove cards");
                        if (od.equalsIgnoreCase("yes")) {
                            for (int k = 0; k < 3; k++) {
                                selectedCards.add(sc.nextInt());
                            }
                        } else if (od.equalsIgnoreCase("no")) {
                            for (int k = 0; k < 2; k++) {
                                selectedCards.add(sc.nextInt());
                            }
                        } else if (od.equalsIgnoreCase("exit")) {
                            break;
                        }
                        if (!game.playAndReplace(selectedCards)) {
                            System.out.println("Wrong answer, you lost");
                            break;
                        }
                        if (game.isWon()) {
                            System.out.println("Congratulations you won");
                            break;
                        }
                    }
                    System.out.println("Play again? press 3");
                    System.out.println("Exit? press 4");
                }
            }
        } while (choice != 4);
    }
}



