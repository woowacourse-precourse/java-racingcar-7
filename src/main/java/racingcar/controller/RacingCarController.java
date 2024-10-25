package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarService;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {

    public void run() {
        List<String> userInputs = RacingCarInput.getUserInput();

        List<RacingCar> cars = new ArrayList<>();
        NameExtractor.extractNames(userInputs.get(0)).stream()
                .forEach(name -> cars.add(new RacingCar(name)));

        RacingCarService racingCarService =
                new RacingCarService(cars, Integer.parseInt(userInputs.get(1)));

        racingCarService.startRacing();
    }
}
