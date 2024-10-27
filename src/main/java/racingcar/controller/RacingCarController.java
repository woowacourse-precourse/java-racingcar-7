package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.ViewMessage;
import racingcar.domain.Car;
import racingcar.domain.ForwardCount;
import racingcar.domain.Input;
import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    public void run() {
        Race race = Race.of(inputCarNames(), inputForwardCount());
        OutputView.println(race.startRace());
    }

    private Car inputCarNames() {
        InputView.showInputPrompt(ViewMessage.CAR_NAME_INPUT_PROMPT);
        return Car.from(Input.from(readInput()).getNames());
    }

    private int inputForwardCount() {
        InputView.showInputPrompt(ViewMessage.FORWARD_COUNT_INPUT_PROMPT);
        return ForwardCount.from(readInput()).getForwardCount();
    }

    public static String readInput() {
        return Console.readLine();
    }

}