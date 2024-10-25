package racingcar.view;

import racingcar.model.Car;

import java.util.List;

import static racingcar.model.Message.GET_WINNER_MESSAGE;
import static racingcar.model.Message.RUN_RESULT_MESSAGE;

public class OutputView {

    // 시도 횟수별 결과 출력
    public static void printRunResult(List<Car> cars) {
        System.out.println(RUN_RESULT_MESSAGE);
        for (Car car : cars) {
            printCarRunResult(car);
        }
    }

    // 차량별 중간 결과 출력
    public static void printCarRunResult(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getMove(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    // 우승자 출력
    public static void printWinner(List<String> cars) {
        System.out.print(GET_WINNER_MESSAGE);
        System.out.println(String.join(",", cars));
    }
}