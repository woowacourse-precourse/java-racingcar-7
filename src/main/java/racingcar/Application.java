package racingcar;

public class Application {
    public static void main(String[] args) {
        Participants participants = new Participants(InputHandler.getNameOfCars());
        int raceTimes = InputHandler.getRaceTimes();
        participants.raceManyTimes(raceTimes);
        participants.printWinner();
    }
}
