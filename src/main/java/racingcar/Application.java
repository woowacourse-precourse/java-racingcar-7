package racingcar;

import racingcar.controller.CarController;
import racingcar.domain.CarMapper;
import racingcar.domain.CarRace;
import racingcar.view.CarInput;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        final var inputName = CarInput.inputCarsName();
        final var inputLap = CarInput.inputCarRaceRap();

        final CarRace carRace = CarMapper.mapCarRaceByName(inputName, inputLap);
        final CarController carController = new CarController();

        carController.race(carRace);
    }
}
