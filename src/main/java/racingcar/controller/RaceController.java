package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Race;
import racingcar.util.InputValidator;
import racingcar.view.RaceView;

import java.util.Arrays;
import java.util.List;

public class RaceController {

    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = Arrays.asList(Console.readLine().split(","));

        InputValidator.validateCarNames(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String attemptInput = Console.readLine();

        InputValidator.validateAttempt(attemptInput);
        int attempts = Integer.parseInt(attemptInput);

        Race race = new Race(carNames, attempts);
        race.startRace();

        List<String> winners = race.getWinners();
        RaceView.displayWinners(winners);

    }
}
