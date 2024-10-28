package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.policy.MovePolicy;
import racingcar.policy.RandomMovePolicy;
import racingcar.race.Race;
import racingcar.separator.InputSeparator;
import racingcar.view.RaceView;

import java.util.List;

public class Application {
    private static final MovePolicy policy = new RandomMovePolicy();

    public static void main(String[] args) {
        RaceView.displayCarNameInputMessage();
        String text = Console.readLine();
        RaceView.displayAttemptCountMessage();
        int count = Integer.parseInt(Console.readLine());

        List<String> carNames = InputSeparator.split(text);
        Race race = new Race(carNames);

        for (int i = 0; i < count; i++) {
            runProcess(race, carNames);
            RaceView.displayProgress(race.getRaceProgress());
        }

        List<String> winners = race.getWinners();
        RaceView.displayWinners(winners);
    }

    private static void runProcess(Race race, List<String> carNames) {
        for (String car : carNames) {
            if (policy.canMove()) {
                race.updateProgress(car);
            }
        }
    }
}
