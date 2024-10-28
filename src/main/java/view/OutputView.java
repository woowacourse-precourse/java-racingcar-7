package view;

import domain.Car;
import domain.Cars;
import domain.Winner;

public class OutputView {

    private static final String INPUT_CAR_NAMES_PHRASE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT = "시도할 횟수는 몇 회인가요?";
    private static final String OUTPUT_RESULT = "실행 결과";
    private static final String OUTPUT_WINNER = "최종 우승자 : ";
    private static final String CAR_MOVE_STATUS = "-";

    public static void printInputCarNames() {
        System.out.println(INPUT_CAR_NAMES_PHRASE);
    }

    public static void printInputTryCount() {
        System.out.println(INPUT_TRY_COUNT);
    }

    public static void printOutputResult() {
        System.out.println();
        System.out.println(OUTPUT_RESULT);
    }

    public static void printOutputStatus(final Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.printf("%s : %s\n", car.getName(), convertStatus(car.getStatus()));
        }
        System.out.println();
    }

    public static void printOutputWinner(final Winner winner) {
        String joinDelimiter = String.join(", ", winner.getWinner().split(" "));
        System.out.println(OUTPUT_WINNER + joinDelimiter);
    }

    private static String convertStatus(final int status) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < status; i++) {
            sb.append(CAR_MOVE_STATUS);
        }
        return sb.toString();
    }
}
