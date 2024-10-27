package racingcar.view;

import static racingcar.constant.OutputMessage.*;

import java.util.List;

import racingcar.dto.CarDto;

public class OutputView {

    private OutputView() {
    }

    public static void inputCarNames() {
        print(INPUT_CAR_NAMES.getMessage());
    }

    public static void inputTryCount() {
        print(INPUT_TRY_COUNT.getMessage());
    }

    public static void resultMessage() {
        print(RESULT.getMessage());
    }

    public static void roundResult(List<CarDto> cars) {
        cars.forEach(car ->
            print(ROUND_RESULT_CAR.getMessage(car))
        );
        print(NEW_LINE.getMessage());
    }

    public static void finalResult(List<CarDto> winners) {
        List<String> winnerNames = winners.stream()
            .map(CarDto::name)
            .toList();
        print(FINAL_WINNER.getMessage(winnerNames));
    }

    private static void print(String content) {
        System.out.print(content);
    }
}
