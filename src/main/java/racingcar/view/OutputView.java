package racingcar.view;

import static racingcar.common.constant.GameMessages.*;
import static racingcar.common.constant.RegexPatterns.*;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.RacingCar;

public class OutputView {
    public void printResultGuideMessage() {
        System.out.println(OUTPUT_RESULT_GUIDE_MESSAGE);
    }

    public void resultMessageLoop(List<RacingCar> racingCars) {
        racingCars.forEach(racingCar -> {
            printResultMessage(racingCar.getName(), racingCar.getScore());
        });
        System.out.println();
    }

    public void printResultMessage(String name, Integer number) {
        System.out.print(name + " : ");
        IntStream.range(0, number)
                .forEach(i -> System.out.print(OUTPUT_SCORE_CHARACTER));
        System.out.println();
    }

    public void printWinnerMessage(List<String> winners) {
        System.out.print(OUTPUT_WINNER_GUIDE_MESSAGE);
        String result = String.join(DELIMITER + " ", winners);
        System.out.print(result);
    }
}