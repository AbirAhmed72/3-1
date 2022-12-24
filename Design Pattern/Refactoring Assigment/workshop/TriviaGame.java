package workshop;

import java.util.ArrayList;
import java.util.LinkedList;

public class TriviaGame {
    private class Player {                                          //class extraction
        int place;
        int purse;
        boolean inPenaltyBox;
    }

    private List<String> players;
    private List<Player> playerData;
    private LinkedList<String> popQuestions;
    private LinkedList<String> scienceQuestions;
    private LinkedList<String> sportsQuestions;
    private LinkedList<String> rockQuestions;
    private int currentPlayer;
    private boolean isGettingOutOfPenaltyBox;

    public TriviaGame() {
        players = new ArrayList<>();
        playerData = new ArrayList<>();
        popQuestions = new LinkedList<>();
        scienceQuestions = new LinkedList<>();
        sportsQuestions = new LinkedList<>();
        rockQuestions = new LinkedList<>();

        for (int i = 0; i < 50; i++) {
            popQuestions.addLast(createPopQuestion(i));
            scienceQuestions.addLast(createScienceQuestion(i));         //method extraction
            sportsQuestions.addLast(createSportsQuestion(i));
            rockQuestions.addLast(createRockQuestion(i));
        }
    }

    public String createPopQuestion(int index) {
        return "Pop Question " + index;
    }
    public String createScienceQuestion(int index) {
        return "Science Question " + index;
    }
    public String createSportsQuestion(int index) {
        return "Sports Question " + index;
    }
    public String createRockQuestion(int index) {
        return "Rock Question " + index;
    }

    public boolean isPlayable() {
        return players.size() >= 2;
    }

    public boolean addPlayer(String playerName) {           //inappropriate method name changed
        players.add(playerName);
        Player newPlayer = new Player();
        newPlayer.place = 0;
        newPlayer.purse = 0;
        newPlayer.inPenaltyBox = false;
        playerData.add(newPlayer);

        announce(playerName + " was added");
        announce("They are player number " + players.size());
        return true;
    }

    public void rollGame(int roll) {                                            //inappropriate method name solved
        announce(players.get(currentPlayer) + " is the current player");
        announce("They have rolled a " + roll);

        Player currentPlayerData = playerData.get(currentPlayer);
        if (currentPlayerData.inPenaltyBox) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;
                announce(players.get(currentPlayer) + " is getting out of the penalty box");
            } else {
                announce(players.get(currentPlayer) + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
                return;
            }
        }
        currentPlayerData.place += roll;
        if (currentPlayerData.place > 11) currentPlayerData.place -= 12;
        announce(currentPlayerData.name + "'s new location is " + currentPlayerData.place);
        announce("The category is " + currentCategory());                          //duplicate code removed
        askQuestion();
    }

    private void askQuestion() {
        String category = currentCategory();
        if (category.equals("Pop"))
            announce(popQuestions.removeFirst());
        if (currentCategory() == "Science")
            announce(scienceQuestions.removeFirst());
        if (currentCategory() == "Sports")
            announce(sportsQuestions.removeFirst());
        if (currentCategory() == "Rock")
            announce(rockQuestions.removeFirst());
    }


    private String currentCategory() {
        int place = playerData.get(currentPlayer).place;
        if (place == 0 || place == 4 || place == 8) return "Pop";                   //simplified if statements
        if (place == 1 || place == 5 || place == 9) return "Science";
        if (place == 2 || place == 6 || place == 10) return "Sports";
        else return "Rock";
    }

    public boolean wasCorrectlyAnswered() {
        Player currentPlayerData = playerData.get(currentPlayer);
        if (currentPlayerData.inPenaltyBox) {
            if (isGettingOutOfPenaltyBox) {
                announce("Answer was correct!!!!");
                currentPlayerData.purse++;
                announce(players.get(currentPlayer) + " now has " + currentPlayerData.purse + " Gold Coins.");

                boolean isWinner = didPlayerWin();
                advanceCurrentPlayer();                                         //long method smell solved

                return isWinner;
            } else {
                advanceCurrentPlayer();
                return true;
            }
        } else {
            announce("Answer was correct!!!!");
            currentPlayerData.purse++;
            announce(players.get(currentPlayer) + " now has " + currentPlayerData.purse + " Gold Coins.");

            boolean isWinner = didPlayerWin();
            advanceCurrentPlayer();

            return isWinner;
        }
    }

    private void advanceCurrentPlayer() {                            //method extraction used
        currentPlayer++;
        if (currentPlayer == players.size()) {
            currentPlayer = 0;
        }
    }

   //dead code removed

    private boolean didPlayerWin() {
        return playerData.get(currentPlayer).purse != 6;
    }

    protected void announce(Object message) {
        System.out.println(message);
    }
}
