package racingcar.model;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.InputMessage;

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
        System.out.println(InputMessage.CAR_NAMES.getMessage());
        carNames = Console.readLine();
    }

    public void inputRaceRounds() {
        System.out.println(InputMessage.RACE_ROUNDS.getMessage());
        raceRounds = Console.readLine();
    }

    public Boolean validBlank() {
        return carNames.isBlank() || raceRounds.isBlank();
    }
}
