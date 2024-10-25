package racingcar;

import java.util.List;

public class CarRacingGame {

    private final IOutputDisplay outputDisplay;
    private final List<ICar> carList;
    private final int round;

    public CarRacingGame(IOutputDisplay outputDisplay, List<ICar> carList, int round) {
        this.outputDisplay = outputDisplay;
        this.carList = carList;
        this.round = round;
    }

    public void start() {
        outputDisplay.print("실행 결과\n");

        for (int i = 0; i < round; i++) {
            round();
            outputDisplay.printRoundResult(carList);
        }
    }

    private void round() {
        for (ICar car : carList) {
            car.drive();
        }
    }
}
