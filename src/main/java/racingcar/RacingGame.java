package racingcar;

import racingcar.io.Input;

public class RacingGame {

    private RacingCars racingCars;
    private int gameCount;

    public RacingGame() {
        this.racingCars = new RacingCars();
        gameCount = 0;
    }


    public void gameCountPreparation() {
        gameCount = Input.readToInteger();
    }

    public void racingCarPreparation() {
        String carNameWithDelimiter = Input.readNames();
        StringSeparator stringSeparator = new StringSeparator(carNameWithDelimiter, ",");
        while (stringSeparator.hasNext()) {
            racingCars.registRacingCar(new RacingCar(stringSeparator.next()));
        }
    }
}
