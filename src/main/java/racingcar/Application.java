package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.process.MovePolicy;
import racingcar.race.Race;
import racingcar.separator.InputSeparator;
import racingcar.view.RaceView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        RaceView.displayCarNameInputMessage();
        String text = Console.readLine();

        RaceView.displayAttemptCountMessage();
        int count = Integer.parseInt(Console.readLine());

        List<String> carNames = InputSeparator.split(text);
        MovePolicy policy = new MovePolicy();
        Race race = new Race(carNames);
        for (int i = 0; i < count; i++) {

            for (String car : carNames) {
                if (policy.run()) {
                    race.updateProgress(car);
                }
            }

            RaceView.displayProgress(race.getRaceProgress());
        }

        List<String> winners = race.getWinners();
        RaceView.displayWinners(winners);

    }
}
