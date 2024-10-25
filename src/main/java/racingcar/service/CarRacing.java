package racingcar.service;

import java.util.List;
import racingcar.context.Car;
import racingcar.view.OutputView;
import racingcar.view.PrintMessage;

public class CarRacing {
    private final Integer totalRaceRound;
    private List<Car> carGroup;

    public CarRacing(String totalRaceRound, List<Car> carGroup) {
        this.totalRaceRound = Integer.parseInt(totalRaceRound); //검증, 예외 처리 필요
        this.carGroup = carGroup;
    }

    public void startCarRacing() {
        for (int raceRound = 0; raceRound < totalRaceRound; raceRound++) {
            carGroup.forEach(Car::moveCar);
            OutputView.printMessageWithLine(PrintMessage.LINE_SPACE);
        }
    }
}
