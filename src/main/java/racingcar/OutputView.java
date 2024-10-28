package racingcar;

import static racingcar.GameMessages.*;
import static racingcar.RegexPatterns.*;

import java.util.List;
import java.util.stream.IntStream;

public class OutputView {
    void printResultGuideMessage() {
        System.out.println(OUTPUT_RESULT_GUIDE_MESSAGE);
    }

    void resultMessageLoop(List<RacingCar> racingCars) {
        racingCars.forEach(racingCar -> {
            printResultMessage(racingCar.getName(), racingCar.getScore());
        });
        System.out.println();
    }

    void printResultMessage(String name, Integer number) {
        System.out.print(name + " : ");
        IntStream.range(0, number)
                .forEach(i -> System.out.print(OUTPUT_SCORE_CHARACTER));
        System.out.println();
    }

    void printWinnerMessage(List<String> winners) {
        System.out.print(OUTPUT_WINNER_GUIDE_MESSAGE);
        String result = String.join(DELIMITER + " ", winners);
        System.out.print(result);
    }
}