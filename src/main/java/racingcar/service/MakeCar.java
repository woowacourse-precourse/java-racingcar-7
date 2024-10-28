package racingcar.service;

import racingcar.car.RacingCar;

public class MakeCar {

    public RacingCar[] makeCar(String[] splitUserInput) {

        RacingCar[] racingCar = new RacingCar[splitUserInput.length];

        for (int i = 0; i < splitUserInput.length; i++) { //
            racingCar[i] = new RacingCar(splitUserInput[i]);
        }

        return racingCar;
    }
}
