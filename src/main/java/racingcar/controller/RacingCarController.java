package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarService;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    RacingCarService racingCarService;

    public void run() {
        List<String> userInputs = RacingCarInput.getUserInput();

        List<RacingCar> cars = new ArrayList<>();
        NameExtractor.extractNames(userInputs.get(0)).stream()
                .forEach(name -> cars.add(new RacingCar(name)));

        racingCarService = new RacingCarService(cars, Integer.parseInt(userInputs.get(1)));

        racingCarService.startRacing();
    }
}
