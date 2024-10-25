package racingcar.model;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.message.Message.INPUT_CAR_NAMES_MESSAGE;
import static racingcar.message.Message.INPUT_RACE_ROUNDS_MESSAGE;

public class OriginInput {
    private String carNames;
    private String raceRounds;

    public OriginInput() {}

    public String getCarNames() {
        return carNames;
    }

    public String getRound() {
        return raceRounds;
    }

    public void inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        carNames = Console.readLine();
    }

    public void inputRaceRounds() {
        System.out.println(INPUT_RACE_ROUNDS_MESSAGE);
        raceRounds = Console.readLine();
    }

    public Boolean validBlank() {
        return carNames.isBlank() || raceRounds.isBlank();
    }
}
