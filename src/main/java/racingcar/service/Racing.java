package racingcar.service;

import java.util.List;
import racingcar.context.RacingCar;
import racingcar.view.OutputView;
import racingcar.view.PrintMessage;

public class Racing {
    private final Integer totalRacingRound;
    private final List<RacingCar> racingCars;

    public Racing(String totalRacingRound, List<RacingCar> racingCars) {
        this.totalRacingRound = Integer.parseInt(totalRacingRound); //검증, 예외 처리 필요
        this.racingCars = racingCars;
    }

    public void startRacing() {
        for (int racingRound = 0; racingRound < totalRacingRound; racingRound++) {
            racingCars.forEach(RacingCar::moveCar);
            OutputView.printMessageWithLine(PrintMessage.LINE_SPACE);
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
