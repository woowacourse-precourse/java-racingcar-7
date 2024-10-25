package racingcar.service;

import java.util.List;
import racingcar.model.Car;
import racingcar.view.OutputView;
import racingcar.view.PrintMessage;

public class Racing {
    private final Integer totalRacingRound;
    private final List<Car> racingCars;

    public Racing(String totalRacingRound, List<Car> cars) {
        this.totalRacingRound = Integer.parseInt(totalRacingRound); //검증, 예외 처리 필요
        this.racingCars = cars;
    }

    public void startRacing() {
        for (int racingRound = 0; racingRound < totalRacingRound; racingRound++) {
            racingCars.forEach(Car::tryMoving);
            OutputView.printMessageWithLine(PrintMessage.LINE_SPACE);
        }
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }
}
