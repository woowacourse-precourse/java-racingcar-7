package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarRace;
import racingcar.view.CarInput;
import racingcar.view.CarOutput;

import java.util.List;

public class CarController {

    public void race(CarRace carRace) {

        for(int i=0;i<carRace.getLapCount();i++) {
            carRace.getCars().forEach(Car::move);
            CarOutput.outputResultPerRap(carRace);
        }

        int maxPosition = carRace.findMaxPosition();
        List<Car> winners = carRace.findCarsByPosition(maxPosition);

        CarOutput.outputWinnersName(winners);
    }
}
