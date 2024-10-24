package racingcar.view;

import racingcar.model.Car;
import racingcar.view.messages.InteractionMessageEnum;

import java.util.List;

public class OutputView {
    public static void printCarNames() {
        System.out.println(InteractionMessageEnum.CAR_NAMES);
    }

    public static void printAttemptCount() {
        System.out.println(InteractionMessageEnum.ATTEMPT_COUNT);
    }

    public static void printResultMessage() {
        System.out.println(InteractionMessageEnum.RESULT_MESSAGE);
    }

    public static void printResult(List<Car> allCars) { //TODO: 이거 static 맞나??

    }

    public static void printWinner(List<String> winners) {
        //TODO: 이렇게 한줄한줄 해야되나?
        System.out.print(InteractionMessageEnum.WINNERS_MESSAGE);
        System.out.print(InteractionMessageEnum.COLON);

        //TODO: 아래 로직 메서드 분리 할지말지?
        for (int i = 0; i < winners.size(); i++) {
            if (i == winners.size() - 1) {
                System.out.println(winners.get(i));
                break;
            }
            System.out.print(winners.get(i) + InteractionMessageEnum.COMMA);
        }
    }
}
