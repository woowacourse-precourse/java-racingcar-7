package racingcar.view;

import racingcar.model.Car;
import racingcar.view.messages.InteractionMessageEnum;

import java.util.List;

public class OutputView {

    public static void printCarNames() {
        extractAndBreak(InteractionMessageEnum.CAR_NAMES);
    }

    public static void printAttemptCount() {
        extractAndBreak(InteractionMessageEnum.ATTEMPT_COUNT);
    }

    public static void printResultMessage() {
        System.out.print("\n");
        extractAndBreak(InteractionMessageEnum.RESULT_MESSAGE);
    }

    public static void printResult(List<Car> cars) {
        for (Car car: cars) {
            System.out.print(car.getName());
            extract(InteractionMessageEnum.COLON);
            System.out.println(InteractionMessageEnum.HYPHEN.getInteractionMessage().repeat(car.getMove()));
        }
        System.out.print("\n");
    }

    public static void printWinner(List<Car> winners) {
        extract(InteractionMessageEnum.WINNERS_MESSAGE);
        extract(InteractionMessageEnum.COLON);

        for (int i = 0; i < winners.size() - 1; i++) {
            System.out.print(winners.get(i).getName());
            extract(InteractionMessageEnum.COMMA);
        }
        System.out.println(winners.get(winners.size() - 1).getName());
    }

    private static void extractAndBreak(InteractionMessageEnum interactionMessageEnum) {
        System.out.println(interactionMessageEnum.getInteractionMessage());
    }

    private static void extract(InteractionMessageEnum interactionMessageEnum) {
        System.out.print(interactionMessageEnum.getInteractionMessage());
    }
}
