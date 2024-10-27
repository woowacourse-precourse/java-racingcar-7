package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        String[] carNames = Validator.getCarNames();
        int trialCount = Validator.getTrialCount();

        Race race = new Race(carNames, trialCount);
        race.simulate();
        race.printWinner();
    }
}
