package racingcar;

import java.util.List;
import racingcar.io.Input;
import racingcar.io.Output;

public class RacingGame {

    private RacingCars racingCars;
    private int gameCount;

    public RacingGame() {
        this.racingCars = new RacingCars();
        gameCount = 0;
    }

    protected RacingGame(RacingCars racingCars, int gameCount) {
        this.racingCars = racingCars;
        this.gameCount = gameCount;
    }

    public void preparation() {
        racingCarPreparation();
        gameCountPreparation();
    }

    public void gameCountPreparation() {
        Output.printGameCountGuide();
        gameCount = Input.readToInteger();
    }

    public void racingCarPreparation() {
        Output.printNameGuide();
        String carNameWithDelimiter = Input.readString();
        StringSeparator stringSeparator = new StringSeparator(carNameWithDelimiter, ",");
        while (stringSeparator.hasNext()) {
            racingCars.registRacingCar(new RacingCar(stringSeparator.next()));
        }
    }

    public void progress() {
        racingCars.moveOrNotForAll();
        Output.printManyLines(racingCars.toString());
    }

    public void progressAll() {
        Output.printProgressGuide();
        while (gameCount-- > 0) {
            progress();
        }
    }

    public void printWinner() {
        List<String> winnerCars = racingCars.findFurthestCarsName();
        Output.printWinner(String.join(", ", winnerCars));
    }
}
