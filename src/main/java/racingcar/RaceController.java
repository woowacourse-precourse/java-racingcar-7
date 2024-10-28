package racingcar;

import java.util.List;

public class RaceController {
    private final Race race = new Race();
    private final InputHandler inputHandler;

    public RaceController(ConsoleReader consoleReader) {
        this.inputHandler = new InputHandler(consoleReader);
    }

    public void startRace() {
        String[] carNames = inputHandler.inputCarNames();
        for (String carName : carNames) {
            race.addCar(new Car(carName.trim()));
        }

        int moveCount = inputHandler.inputMoveCount();
        race.setMoveCount(moveCount);
    }

    public void executeRace() {
        System.out.println("실행 결과");
        for (int i = 0; i < race.getMoveCount(); i++) {
            race.playTurn();
            printRaceStatus();
        }
    }

    public void endRace() {
        List<String> winners = race.getWinners();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private void printRaceStatus() {
        for (Car car : race.getCarsStatus()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public Race getRace() {
        return race;
    }

}
