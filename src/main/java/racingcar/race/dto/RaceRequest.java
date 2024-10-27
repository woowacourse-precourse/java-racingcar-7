package racingcar.race.dto;

import camp.nextstep.edu.missionutils.Console;
import racingcar.race.domain.RaceMessage;

public class RaceRequest {
    public String enterRaceNumbetInteger() {
        RaceMessage.printMessage();
        return Console.readLine();
    }
}
