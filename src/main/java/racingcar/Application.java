package racingcar;

public class Application {
    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar();

        racingCar.getCarNames();
        racingCar.removeBlank();
        racingCar.extractCarNames();
        racingCar.getTryCount();
        racingCar.makeRaceStatus();
        racingCar.startRace();
        racingCar.checkMaxMoveCount();
        racingCar.printWinner();
    }
}
