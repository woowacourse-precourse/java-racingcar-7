package racingcar.controller.IO;

import racingcar.model.RacingCar;

import java.util.List;

public interface OutputController {
    void requestUserCarsInput();
    void requestUserRoundInput();
    void printWinner(List<RacingCar> winners);
    void printCarsCurrentDistance(List<RacingCar> racingCars);
}
