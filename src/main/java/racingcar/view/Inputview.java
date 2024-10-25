package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.vo.Round;

public class Inputview {

    public String inputCarNames() {
        String input = Console.readLine();
        Console.close();

        return input;
    }

    public int inputRound() {
        String input = Console.readLine();
        Console.close();

        Round round = Round.fromString(input);
        return round.round();
    }
}
