package racingcar;

import static racingcar.GameMessages.OUTPUT_RESULT_GUIDE_MESSAGE;
import static racingcar.GameMessages.OUTPUT_SCORE_CHARACTER;
import static racingcar.GameMessages.OUTPUT_WINNER_GUIDE_MESSAGE;

import java.util.List;

public class OutputView {
    void printResultGuideMessage() {
        System.out.println(OUTPUT_RESULT_GUIDE_MESSAGE);
    }

    void resultMessageLoop(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            printResultMessage(racingCar.getName(), racingCar.getScore());
        }
        System.out.println();
    }

    void printResultMessage(String name, Integer number) {
        System.out.print(name + " : ");
        for (int i = 0; i < number; i++) {
            System.out.print(OUTPUT_SCORE_CHARACTER);
        }
        System.out.println();
    }

    void printWinnerMessage(List<String> winners) {
        System.out.print(OUTPUT_WINNER_GUIDE_MESSAGE);

        for (int i = 0; i < winners.size(); i++) {
            if (i == winners.size() - 1) {
                System.out.print(winners.get(i));
                break;
            }
            System.out.print(winners.get(i) + ", ");
        }
    }
}