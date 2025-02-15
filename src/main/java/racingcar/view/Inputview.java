package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.vo.Round;

public class Inputview {

    public String inputCarNames() {
        return Console.readLine();
    }

    public int inputRound() {
        String input = Console.readLine();
        Round round = Round.fromString(input);
        return round.round();
    }
}
