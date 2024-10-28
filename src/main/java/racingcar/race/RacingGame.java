package racingcar.race;

import static racingcar.race.constant.RacingPromptMessage.CAR_NAME_TO_ENTER_TEXT;
import static racingcar.race.constant.RacingPromptMessage.EXECUTION_RESULT_TEXT;
import static racingcar.race.constant.RacingPromptMessage.NUMBER_OF_ATTEMPTS_TO_ENTER_TEXT;
import static racingcar.race.constant.RacingPromptMessage.WINNER_RESULT_TEXT;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.race.manager.DelimiterManager;
import racingcar.race.manager.ParseManager;
import racingcar.race.manager.ValidManager;
import racingcar.race.model.Racer;

public class RacingGame {

    private final ParseManager parseManager;
    private final ValidManager validManager;
    private final DelimiterManager delimiterManager;

    public RacingGame(ParseManager parseManager,
                      ValidManager validManager,
                      DelimiterManager delimiterManager) {
        this.parseManager = parseManager;
        this.validManager = validManager;
        this.delimiterManager = delimiterManager;
    }

    private static void displayWinners(Racer racer) {
        System.out.print(WINNER_RESULT_TEXT);
        String winners = racer.getWinners();
        System.out.println(winners);
    }

    private static void displayExecute(Racer racer, int round) {
        System.out.println(EXECUTION_RESULT_TEXT);
        String executionResult = racer.getExecutedRound(round);
        System.out.println(executionResult);
    }

    public void start() {
        Racer racer = Racer.of(enterNames());
        int round = enterRound();
        displayExecute(racer, round);
        displayWinners(racer);
    }

    private List<String> enterNames() {
        System.out.println(CAR_NAME_TO_ENTER_TEXT);
        String names = Console.readLine();
        List<String> carNames = delimiterManager.splitByDefault(names);
        validManager.validateSize(carNames);
        return carNames;
    }

    private int enterRound() {
        System.out.println(NUMBER_OF_ATTEMPTS_TO_ENTER_TEXT);
        int round = parseManager.toInt(Console.readLine());
        validManager.validateRange(round);

        return round;
    }
}
