package vikvlaeg.ui;

public class GameInfo {

    public String rules() {
        return "Rules of ElevenGame";

//                You will have a 9 cards on the table and 43 on the deck
//                To win, it is necessary that there are no cards left on the table or in the deck
//                You can remove 2 cards, which give 11 or 3 cards, which give a triple (jack, queen, king)
//                If you don't answer correctly, you lose
//                To exit the game, write exit
//                Have fun";
    }

    public String beatifulRules() {
        return Colors.BG_RED + "Rules of ElevenGame" + Colors.RESET_COLOR + "\n" +
                "\n" + Colors.BG_YELLOW + "You will have a 9 cards on the table and 43 on the deck" + Colors.RESET_COLOR +
                "\n" + Colors.BG_GREEN +  "To win, it is necessary that there are no cards left on the table or in the deck" + Colors.RESET_COLOR +
                "\n" + Colors.BRIGHT_BG_BLUE + "You can remove 2 cards, which give 11 or 3 cards, which give a triple (jack, queen, king)" + Colors.RESET_COLOR +
                "\n" + Colors.BG_BLUE + "If you don't answer correctly, you lose" + Colors.RESET_COLOR +
                "\n" + Colors.BG_PURPLE + "To exit the game, write exit" + Colors.RESET_COLOR +
                "\n" + Colors.BRIGHT_BG_CYAN + "Have fun" + Colors.RESET_COLOR;
    }



}
