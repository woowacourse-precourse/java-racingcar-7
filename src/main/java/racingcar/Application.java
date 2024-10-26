package racingcar;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        Participants participants = new Participants(inputHandler.getInput());
        int raceTimes = Integer.parseInt(inputHandler.getInput());
        participants.raceManyTimes(raceTimes);
        participants.printWinner();
    }

}
