package racingcar.view;

import racingcar.model.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class Output {
    public static final String DELIMITER_COLON = " : ";
    public static final String DELIMITER_COMMA = ",";
    private static final String MOVE_SIGN = "-";
    public static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String HOW_MANY_ATTEMPTS = "시도할 횟수는 몇 회인가요?";
    public static final String EXECUTION_RESULT = "실행 결과";
    public static final String FINAL_WINNER = "최종 우승자 : ";


    public static void inputCarNames() {
        System.out.println(INPUT_CAR_NAMES);
    }

    public static void inputAttempts() {
        System.out.println(HOW_MANY_ATTEMPTS);
    }

    public static void result(List<Car> cars, int moveCount) {
        System.out.println();
        System.out.println(EXECUTION_RESULT);

        for (int index = 0; index < moveCount; index++) {
            for (Car car : cars) {
                System.out.println(car.getName() + DELIMITER_COLON + convertPositionToString(car, index));
            }
            System.out.println();
        }
    }

    public static void winner(List<Car> winners) {
        System.out.print(FINAL_WINNER);

        String winnerNames
                = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER_COMMA));
        System.out.println(winnerNames);
    }

    private static String convertPositionToString(Car car, int count) {
        return MOVE_SIGN.repeat(car.getPositionAtSpecificCount(count));
    }
}
