package racingcar;

import racingcar.io.Input;
import racingcar.io.Output;

public class RacingGame {

    private RacingCars racingCars;
    private int gameCount;

    public RacingGame() {
        this.racingCars = new RacingCars();
        gameCount = 0;
    }


    public void gameCountPreparation() {
        Output.printGameCountGuide();
        gameCount = Input.readToInteger();
    }

    public void racingCarPreparation() {
        Output.printNameGuide();
        String carNameWithDelimiter = Input.readNotNullAndNotEmptyString();
        StringSeparator stringSeparator = new StringSeparator(carNameWithDelimiter, ",");
        while (stringSeparator.hasNext()) {
            racingCars.registRacingCar(new RacingCar(stringSeparator.next()));
        }
    }
}
