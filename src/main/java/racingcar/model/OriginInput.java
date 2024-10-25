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

    public String getRaceRound() {
        return raceRounds;
    }

    public void inputCarNames() {
        InputMessage.CAR_NAMES.printMessage();
        carNames = Console.readLine();
    }

    public void inputRaceRounds() {
        InputMessage.RACE_ROUNDS.printMessage();
        raceRounds = Console.readLine();
    }
}
